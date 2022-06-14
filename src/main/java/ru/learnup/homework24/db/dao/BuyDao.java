package ru.learnup.homework24.db.dao;

import org.springframework.stereotype.Component;
import ru.learnup.homework24.db.entity.Buy;
import ru.learnup.homework24.db.repository.BuyRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BuyDao {

    private final BuyRepository repository;

    public BuyDao(BuyRepository repository) {
        this.repository = repository;
    }

    public Buy findById(int id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Buy> findAll() {
        List<Buy> buyList = new ArrayList<>();
        Iterable<Buy> buy = repository.findAll();
        buy.forEach(buyList::add);
        return buyList;
    }

    public void save(Buy buy) {
        repository.save(buy);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
