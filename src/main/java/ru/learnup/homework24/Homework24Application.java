package ru.learnup.homework24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.learnup.homework24.db.dao.AuthorDao;
import ru.learnup.homework24.db.dao.BookDao;
import ru.learnup.homework24.db.dao.BuyDao;
import ru.learnup.homework24.db.dao.StockDao;
import ru.learnup.homework24.db.entity.*;
import ru.learnup.homework24.db.exeption.InvalidQuantityException;
import java.util.ArrayList;

@SpringBootApplication
public class Homework24Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Homework24Application.class, args);
		AuthorDao authorDao = context.getBean(AuthorDao.class);
		StockDao stockDao = context.getBean(StockDao.class);
		BookDao bookDao = context.getBean(BookDao.class);
		BuyDao buyDao = context.getBean(BuyDao.class);
		Author author = new Author("Mark", "Tven");
		authorDao.save(author);
		Book book = new Book(1999, "avvcd", 101,76, author);
		Stock stock = new Stock(book,2);
		stockDao.save(stock);
		Book book1 = bookDao.findById(1);
		Buy buy = new Buy();
		buyDao.save(buy);

		System.out.println("Остаток товаров: " + stockDao.findById(book1.getId()).getAmount());
		try {
			buyBook(book1,stockDao, buy);
		} catch (InvalidQuantityException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Остаток товаров: " + stockDao.findById(book1.getId()).getAmount());
		try {
			buyBook(book1,stockDao, buy);
		} catch (InvalidQuantityException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Остаток товаров: " + stockDao.findById(book1.getId()).getAmount());
		try {
			buyBook(book1,stockDao, buy);
		} catch (InvalidQuantityException e) {
			System.out.println(e.getMessage());
		}

	}

	@Transactional (propagation = Propagation.REQUIRED,
					isolation = Isolation.READ_COMMITTED,
					timeout = 3,
					rollbackFor = {InvalidQuantityException.class})
	public static void buyBook (Book book, StockDao stockDao, Buy buy) throws InvalidQuantityException {

		Stock stock = stockDao.findById(book.getId());
		int amount = stock.getAmount();

		if (amount > 0) {
			if (buy.getBuyDetails() == null) {
				BuyDetails buyDetails = new BuyDetails();
				buy.setBuyDetails(buyDetails);
				buy.getBuyDetails().setBooks(new ArrayList<>());
				}
			buy.getBuyDetails().addBook(book);
			stock.setAmount(amount - 1);
			stockDao.save(stock);
			System.out.println("Товар добавлен");

		} else throw new InvalidQuantityException();
	}
}
