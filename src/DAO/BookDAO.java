package DAO;

import Entity.Book;

import java.util.List;

public interface BookDAO {
    Boolean insert(Book book);
    Boolean update(Book book);
    Boolean delete(int book_id);
    List<Book> findAll();
    Book findById(int book_id);
}
