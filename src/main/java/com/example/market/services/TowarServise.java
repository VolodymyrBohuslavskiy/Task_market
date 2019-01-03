package com.example.market.services;

import com.example.market.DAO.TowarDAO;
import com.example.market.models.Towar;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class TowarServise {
    private TowarDAO towarDAO;

    public void save(Towar towar) {
        towarDAO.save(towar);
    }

    public List<Towar> all() {
        List<Towar> all = towarDAO.findAll(Sort.by("id"));
        Collections.reverse(all);
        return all;
    }

    public Towar findById(int id) {
        return towarDAO.findById(id);
    }

    public List<Towar> findAllWithPriceHig(int price) {
        return towarDAO.findAllWithPriceHig(price);
    }

    public List<Towar> ten() {
        if (all().size() >= 10) return all().subList(0, 10);
        else return all().subList(0, all().size() - 1);
    }

    public List<Towar> allABC() {
        return towarDAO.findAll(Sort.by("titel"));
    }


//ЗАВЖИ ТРЕБА КОНСТРУКТОР або анотоція У Servise  !!!!!!!


//
//    public TowarServise(TowarDAO towarDAO) {
//        this.towarDAO = towarDAO;
//    }
}
