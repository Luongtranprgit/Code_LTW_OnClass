package com.example.bookory.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookory.book.Book;
import com.example.bookory.book.BookRespository;
import com.example.bookory.purchase.Purchase;
import com.example.bookory.purchase.PurchaseRepository;
import com.example.bookory.purchase.PurchaseService;

import jakarta.transaction.Transactional;

@Service
public class CartService {
	@Autowired
	private CartRepository repo;
	@Autowired
	private BookRespository bookRepo;

	@Autowired
	private PurchaseService purService;

	public List<CartRes> getUserCart(int userid) {
		List<Cart> list = repo.findByUserid(userid);
		List<CartRes> res = new ArrayList<CartRes>();
		for (Cart item : list) {
			if (item.getStatus().equals("cart")) {
				CartRes cartItem = new CartRes();
				Book book = getBookInfo(item.getBookid());
				cartItem.setId(item.getId());
				cartItem.setTitle(book.getTitle());
				cartItem.setAuthor(book.getAuthor());
				cartItem.setSlug(book.getSlug());
				cartItem.setQuantity(item.getQuantity());
				cartItem.setPrice(book.getPrice());
				res.add(cartItem);
			}
		}
		return res;
	}

	public Book getBookInfo(int id) {
		Optional<Book> book = bookRepo.findById(id);
		return book.get();
	}

	public void addItem(Cart cart) {
		Cart data = repo.findByUseridAndBookidAndStatus(cart.getUserid(), cart.getBookid(), "cart").map(item -> {
			item.setQuantity(item.getQuantity() + cart.getQuantity());
			return repo.save(item);
		}).orElseGet(() -> {
			Cart newItem = new Cart();
			newItem.setBookid(cart.getBookid());
			newItem.setUserid(cart.getUserid());
			newItem.setQuantity(cart.getQuantity());
			newItem.setStatus("cart");
			return repo.save(newItem);
		});
	}

	@Transactional
	public String deleteCartItem(int id) {
		repo.deleteById(id);
		return "200";
	}

	public void increaseQuantity(int id) {
		Optional<Object> data = repo.findById(id).map(item -> {
			item.setQuantity(item.getQuantity() + 1);
			return repo.save(item);
		});

	}

	public void decreaseQuantity(int id) {
		Optional<Object> data = repo.findById(id).map(item -> {
			item.setQuantity(item.getQuantity() - 1);
			return repo.save(item);
		});

	}

	public void purchase(String orderid, int userid) {
		List<CartRes> list = this.getUserCart(userid);
		for (CartRes item : list) {
			Optional<Cart> temp = repo.findById(item.getId()).map(cart -> {
				cart.setStatus(orderid);
				return repo.save(cart);
			});
		}
		purService.savePurchase(orderid, "pending");
	}

	public List<Order> getAllOrderByUser(int userid, String status) {
		List<String> listid = repo.getAllStatusByUserid(userid);
		List<Order> res = new ArrayList<>();
		for (String id : listid) {
			if (purService.findOrder(id, status)) {
				List<Cart> list = repo.findByUseridAndStatus(userid, id);
				List<CartRes> cart = new ArrayList<CartRes>();
				Order order = new Order();
				float total = 0;
				for (Cart item : list) {
					CartRes cartItem = new CartRes();
					Book book = getBookInfo(item.getBookid());
					cartItem.setId(item.getId());
					cartItem.setTitle(book.getTitle());
					cartItem.setAuthor(book.getAuthor());
					cartItem.setSlug(book.getSlug());
					cartItem.setQuantity(item.getQuantity());
					cartItem.setPrice(book.getPrice());
					cart.add(cartItem);
					total += book.getPrice();
				}
				order.setId(id);
				order.setProducts(cart);
				order.setTotal((float) (Math.round(total * 100.0) / 100.0));
				res.add(order);
			}
		}
		return res;
	}
}
