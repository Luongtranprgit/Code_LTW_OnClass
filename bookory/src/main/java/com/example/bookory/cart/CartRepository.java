package com.example.bookory.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{
	List<Cart> findByUserid(int userid);
	Optional<Cart> findByUseridAndBookidAndStatus(int userid,int bookid,String status);
	List<Cart> findByUseridAndStatus(int userid,String status);
	@Query("select status from Cart where userid = ?1 and status!= 'cart' group by status")
	List<String> getAllStatusByUserid(int userid);
	
}
