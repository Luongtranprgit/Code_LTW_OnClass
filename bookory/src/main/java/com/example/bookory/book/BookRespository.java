package com.example.bookory.book;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRespository extends JpaRepository<Book, Integer>{
	Optional<Book> findBySlug(String slug);
	List<Book> findByCategory(String category);
	Optional<Book> findByTitleAndAuthor(String title,String author);
	@Query(nativeQuery = true,value ="SELECT TOP 6 Book.*, \r\n"
			+ "(SELECT SUM(Cart.quantity) FROM Cart WHERE Cart.bookid = Book.id AND Cart.status!= 'cart') AS sold \r\n"
			+ "FROM Book ORDER BY sold DESC")
	List<Book> getTopBestSeller();
	@Query(nativeQuery = true, value = "select top 4 Book.*, (select count(*) from Comment where Comment.bookid = Book.id) as comment from Book order by comment desc")
	List<Book> getMostViewed();
}
