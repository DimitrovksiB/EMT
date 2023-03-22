package finki.emt.emt.service.IMPL;

import finki.emt.emt.model.Author;
import finki.emt.emt.model.Country;
import finki.emt.emt.model.exceptions.InvalidAuthorException;
import finki.emt.emt.repository.AuthorRepository;
import finki.emt.emt.repository.CountryRepository;
import finki.emt.emt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceIMPL implements AuthorService {

    private AuthorRepository authorRepository;
    private CountryRepository countryRepository;

    @Override
    public List<Author> listAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(InvalidAuthorException::new);
    }

    @Override
    public Author Create(String name, String surname, Country country) {
        Author author = new Author(name, surname,country);
        return authorRepository.save(author);
    }

    @Override
    public Author Update(Long id, String name, String surname, Long countryID) {
        Author author = authorRepository.findById(id).orElseThrow(InvalidAuthorException::new);
        Country country = countryRepository.findById(countryID).orElseThrow(InvalidAuthorException::new);

        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);
        return authorRepository.save(author);
    }

    @Override
    public Author Delete(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(InvalidAuthorException::new);
        authorRepository.delete(author);
        return author;
    }
}
