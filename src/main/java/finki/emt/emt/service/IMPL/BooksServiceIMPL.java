package finki.emt.emt.service.IMPL;

import finki.emt.emt.model.Author;
import finki.emt.emt.model.Books;
import finki.emt.emt.model.enumerations.BookCategory;
import finki.emt.emt.model.exceptions.InvalidAuthorException;
import finki.emt.emt.model.exceptions.InvalidBookException;
import finki.emt.emt.repository.AuthorRepository;
import finki.emt.emt.repository.BookRepository;
import finki.emt.emt.service.BooksService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceIMPL implements BooksService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BooksServiceIMPL(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Books> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Books findById(Long id) {
        return bookRepository.findById(id).orElseThrow(InvalidBookException::new);
    }

    @Override
    public Books Create(String name, BookCategory category, Long authorID, Integer availableCopies) {
        Author author = authorRepository.findById(authorID).orElseThrow(InvalidAuthorException::new);
        Books books = new Books(name, category,author,availableCopies);
        return bookRepository.save(books);
    }

    @Override
    public Books Update(Long id, String name, BookCategory category, Long authorID, Integer availableCopies) {
        Books books = bookRepository.findById(id).orElseThrow(InvalidBookException::new);
        Author author = authorRepository.findById(authorID).orElseThrow(InvalidAuthorException::new);
        books.setName(name);
        books.setAuthor(author);
        books.setAvailableCopies(availableCopies);
        books.setCategory(category);
        return bookRepository.save(books);
    }

    @Override
    public Books Delete(Long id) {
        Books books = bookRepository.findById(id).orElseThrow(InvalidBookException::new);
        bookRepository.delete(books);
        return books;
    }
}
