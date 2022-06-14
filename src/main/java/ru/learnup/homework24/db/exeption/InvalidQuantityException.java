package ru.learnup.homework24.db.exeption;

public class InvalidQuantityException extends RuntimeException {

    public InvalidQuantityException () {
        super("Данный товар уже куплен другим пользователем");
    }
}
