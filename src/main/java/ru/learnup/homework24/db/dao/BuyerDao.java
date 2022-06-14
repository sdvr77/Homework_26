package ru.learnup.homework24.db.dao;

import org.springframework.stereotype.Component;
import ru.learnup.homework24.db.entity.Buyer;
import ru.learnup.homework24.db.repository.BuyerRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BuyerDao {
    private final BuyerRepository repository;

    public BuyerDao(BuyerRepository repository) {
        this.repository = repository;
    }

    public Buyer findById(int id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Buyer> findAll() {
        List<Buyer> buyerList = new ArrayList<>();
        Iterable<Buyer> buyers = repository.findAll();
        buyers.forEach(buyerList::add);
        return buyerList;
    }

    public void save(Buyer buyer) {
        repository.save(buyer);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
