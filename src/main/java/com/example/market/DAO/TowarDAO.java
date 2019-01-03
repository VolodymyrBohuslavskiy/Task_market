package com.example.market.DAO;

import com.example.market.models.Towar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TowarDAO extends JpaRepository<Towar, Integer> {

    Towar findById(int id);

    @Query("select c from Towar c where c.price>:price")
    List<Towar> findAllWithPriceHig(int price);


}
