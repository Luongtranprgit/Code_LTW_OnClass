package com.example.bookory.purchase;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Integer>{
	Optional<Purchase> findByOrderid(String orderid);
	Optional<Purchase> findByOrderidAndStatus(String orderid,String status);
}
