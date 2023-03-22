package finki.emt.emt.service;

import finki.emt.emt.model.Author;
import finki.emt.emt.model.Books;
import finki.emt.emt.model.Country;
import finki.emt.emt.model.enumerations.BookCategory;

import java.awt.print.Book;
import java.util.List;

public interface BooksService {
    List<Books> listAll();
    Books findById(Long id);
    Books Create(String name, BookCategory category, Long authorID, Integer availableCopies);
    Books Update(Long id, String name, BookCategory category, Long authorID, Integer availableCopies);
    Books Delete(Long id);
}
