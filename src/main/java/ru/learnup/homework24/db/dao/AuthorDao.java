package ru.learnup.homework24.db.dao;

import org.springframework.stereotype.Component;
import ru.learnup.homework24.db.entity.Author;
import ru.learnup.homework24.db.repository.AuthorRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorDao {

    private final AuthorRepository repository;

    public AuthorDao(AuthorRepository repository) {
        this.repository = repository;
    }

    public Author findById(int id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Author> findAll() {
        List<Author> authorList = new ArrayList<>();
        Iterable<Author> authors = repository.findAll();
        authors.forEach(authorList::add);
        return authorList;
    }

    public void save(Author author) {
        repository.save(author);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}

