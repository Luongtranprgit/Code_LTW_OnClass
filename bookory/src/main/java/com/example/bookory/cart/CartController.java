package com.example.bookory.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CartController {
	@Autowired
	private CartService service;
	@GetMapping("/carts/{userid}")
	public ResponseEntity<?> getUserCart(@PathVariable int userid){
		List<CartRes> res = service.getUserCart(userid);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
	@PostMapping("/cart/insert")
	public ResponseEntity<?> insertCartItem(@RequestBody Cart cart){
		service.addItem(cart);
		return ResponseEntity.status(HttpStatus.OK).body(200);
	}
	@PostMapping("/cart/delete")
	public ResponseEntity<?> deletetCartItem(@RequestBody Map<String,Integer> requestParam){
		String status = service.deleteCartItem(requestParam.get("id"));
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
	@PostMapping("/cart/update")
	public ResponseEntity<?> updateCartItem(@RequestBody Map<String,Integer> requestParam){
		if(requestParam.get("action") == 1) {
			service.increaseQuantity(requestParam.get("id"));
		}
		else if(requestParam.get("action") == 0) {
			service.decreaseQuantity(requestParam.get("id"));
		}
		return ResponseEntity.status(HttpStatus.OK).body("200");
	}
	@PostMapping("/cart/buy")
	public ResponseEntity<?> purchase(@RequestBody Map<String,String> requestParam){
		int userid = Integer.parseInt(requestParam.get("userid"));
		String orderid = requestParam.get("orderid").substring(8);
		service.purchase(orderid,userid);
		return ResponseEntity.status(HttpStatus.OK).body("200");
	}
	@GetMapping("/order/{status}/{userid}")
	public ResponseEntity<?> getAllOrder(@PathVariable String status,@PathVariable int userid ){
		List<Order> res = service.getAllOrderByUser(userid, status);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
}
