package com.example.bookory.comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookory.book.Book;
import com.example.bookory.book.BookRespository;
import com.example.bookory.user.User;
import com.example.bookory.user.UserRespository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository repo;
	@Autowired
	private UserRespository userRepo;
	@Autowired
	private BookRespository bookRepo;
	public List<CommentRes> getAll(int bookId) {
		List<CommentRes> list = new ArrayList<>();
		List<Comment> res = repo.findByBookid(bookId);
		for(Comment item:res) {
			CommentRes temp = new CommentRes();
			Optional<User> user = userRepo.findById(item.getUserid());
			temp.setId(item.getId());
			temp.setUserName(user.get().getUsername());
			temp.setAvatar(user.get().getAvatar());
			temp.setRate(item.getRate());
			temp.setContent(item.getContent());
			temp.setTimeUp(item.getTimeup());
			list.add(temp);
		}
		return list;
	}
	public String addComment(Comment comment) {
		repo.save(comment);
		changeBookStars(comment.getBookid());
		return "200";
	}
	public void changeBookStars(int id) {
		List<Comment> list = repo.findByBookid(id);
		float sum = 0;
		int count = 0;
		for(Comment item:list) {
			sum += item.getRate();
			count += 1;
		}
		float res = (float) (Math.round((sum/count)*10.0)/10.0);
		Optional<Book> findbook = bookRepo.findById(id).map(book->{
			book.setStars(res);
			return bookRepo.save(book);
		});
		
	}
}
