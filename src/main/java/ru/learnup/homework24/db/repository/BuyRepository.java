package ru.learnup.homework24.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.homework24.db.entity.Buy;

@Repository
public interface BuyRepository extends CrudRepository<Buy, Integer> {
}
