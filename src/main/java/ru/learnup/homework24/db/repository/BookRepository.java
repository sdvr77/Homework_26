package ru.learnup.homework24.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.homework24.db.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
