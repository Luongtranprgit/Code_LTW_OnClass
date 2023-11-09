package com.example.bookory.purchase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository repo;

    public void savePurchase(String orderid, String status) {
        try {
            if (status.equals("pending")) {
                Purchase newpur = new Purchase();
                newpur.setOrderid(orderid);
                newpur.setStatus(status);
                repo.save(newpur);
            } else {
                Optional<Purchase> pur = repo.findByOrderid(orderid);
                pur.ifPresent(item -> {
                    item.setStatus(status);
                    repo.save(item);
                });
            }
        } catch (Exception err) {
            // Xử lý ngoại lệ (Exception) nếu cần
        }
    }
    
    public boolean findOrder(String orderid, String status) {
        Optional<Purchase> find = repo.findByOrderidAndStatus(orderid, status);
        return find.isPresent();
    }
}
