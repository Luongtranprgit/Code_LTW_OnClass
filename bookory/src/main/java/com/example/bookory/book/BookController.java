package com.example.bookory.book;

import java.util.List;

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

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BookController {
	@Autowired
	private BookService service;
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return service.getAll();
	}
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable int id) {
		return service.getOne(id);
	}
	@GetMapping("/book-detail/{slug}")
	public Book getBookDetail(@PathVariable String slug) {
		return service.getBySlug(slug);
	}
	@PostMapping("/book/save")
	public ResponseEntity<?> saveBook(@RequestBody Book book){
		String status = service.saveBook(book);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
	@PostMapping("/book/update/{id}")
	public ResponseEntity<?> updateBook(@RequestBody Book book,@PathVariable int id){
		String status = service.updateBook(book, id);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
	@PostMapping("/book/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable int id){
		String status = service.deleteBook(id);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	} 
	@GetMapping("/books/{category}")
	public List<Book> getBooksByCAtegory(@PathVariable String category){
		return service.getByCategory(category);
	}
	@GetMapping("/books/best-seller")
	public ResponseEntity<?> getBestSeller(){
		List<Book> data = service.getBestSeller();
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
	@GetMapping("/books/most-viewed")
	public ResponseEntity<?> getMostViewed(){
		List<Book> data = service.getMostViewed();
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
}
