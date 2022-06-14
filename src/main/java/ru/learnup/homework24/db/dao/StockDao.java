package ru.learnup.homework24.db.dao;

import org.springframework.stereotype.Component;
import ru.learnup.homework24.db.entity.Stock;
import ru.learnup.homework24.db.repository.StockRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component
public class StockDao {

    private final StockRepository repository;

    public StockDao(StockRepository repository) {
        this.repository = repository;
    }

    public Stock findById(int id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Stock> findAll() {
        List<Stock> stockList = new ArrayList<>();
        Iterable<Stock> stock = repository.findAll();
        stock.forEach(stockList::add);
        return stockList;
    }

    public void save(Stock stock) {
        repository.save(stock);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
