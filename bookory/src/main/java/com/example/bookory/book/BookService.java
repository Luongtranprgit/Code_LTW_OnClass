package com.example.bookory.book;

import java.text.Normalizer;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private BookRespository repo;
	public static String toSlug(String input) {
		final Pattern NONLATIN = Pattern.compile("[^\\w-]");
		final Pattern WHITESPACE = Pattern.compile("[\\s]");
		final Pattern EDGESDHASHES = Pattern.compile("(^-|-$)");
	    String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
	    String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
	    String slug = NONLATIN.matcher(normalized).replaceAll("");
	    slug = EDGESDHASHES.matcher(slug).replaceAll("");
	    return slug.toLowerCase(Locale.ENGLISH);
	}
	public List<Book> getAll(){
		return repo.findAll();
	}
	public List<Book> getByCategory(String category){
		return repo.findByCategory(category);
	}
	public Book getOne(int id){
		return repo.findById(id).get();
	}
	public Book getBySlug(String slug) {
		return repo.findBySlug(slug).get();
	}
	public String saveBook(Book book) {
		String slug = toSlug(book.getTitle());
		Optional<Book> findbook = repo.findBySlug(slug);
		Optional<Book> checkbook = repo.findByTitleAndAuthor(book.getTitle(), book.getAuthor());
		if(findbook.isEmpty() && (checkbook.isEmpty())) {
			book.setSlug(slug);
			book.setStars(0);
			repo.save(book);
			return slug;
		}
		else return "408";
	}
	public String updateBook(Book newbook, int id) {
	    Optional<Book> findbook = repo.findById(id);
	    Optional<Book> checkbook = repo.findByTitleAndAuthor(newbook.getTitle(), newbook.getAuthor());
	    if (findbook.isPresent() && (checkbook.isEmpty() || checkbook.get().getId() != newbook.getId())) {
	        Optional<Book> res = repo.findById(newbook.getId()).map(book -> {
	            book.setTitle(newbook.getTitle());
	            book.setAuthor(newbook.getAuthor());
	            book.setDescription(newbook.getDescription());
	            book.setCategory(newbook.getCategory());
	            book.setPages(newbook.getPages());
	            book.setPrice(newbook.getPrice());
	            book.setRelease(newbook.getRelease());
	            return repo.save(book);
	        });
	        return findbook.get().getSlug();
	    } else {
	        return "404";
	    }
	}
	public String deleteBook(int id) {
		try {
			repo.deleteById(id);
			return "200";
		}catch(Exception e) {
			return "404";
		}
	}
	public List<Book> getBestSeller(){
		return repo.getTopBestSeller();
	}
	public List<Book> getMostViewed(){
		return repo.getMostViewed();
	}
}
