package finki.emt.emt.service;

import finki.emt.emt.model.Author;
import finki.emt.emt.model.Books;
import finki.emt.emt.model.Country;
import finki.emt.emt.model.enumerations.BookCategory;

import java.awt.print.Book;
import java.util.List;

public interface AuthorService {
    List<Author> listAll();
    Author findById(Long id);
    Author Create(String name, String surname, Country country);
    Author Update(Long id,String name, String surname, Long countryID);
    Author Delete(Long id);
}
