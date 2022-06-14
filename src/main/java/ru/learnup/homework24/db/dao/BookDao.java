package ru.learnup.homework24.db.dao;

import org.springframework.stereotype.Component;
import ru.learnup.homework24.db.entity.Book;
import ru.learnup.homework24.db.repository.BookRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDao {

    private final BookRepository repository;

    public BookDao(BookRepository repository) {
        this.repository = repository;
    }

    public Book findById(int id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        Iterable<Book> books = repository.findAll();
        books.forEach(bookList::add);
        return bookList;
    }

    public void save(Book book) {
        repository.save(book);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
