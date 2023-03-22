package finki.emt.emt.service.IMPL;

import finki.emt.emt.model.Country;
import finki.emt.emt.model.exceptions.InvalidCountryException;
import finki.emt.emt.repository.CountryRepository;
import finki.emt.emt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceIMPL implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceIMPL(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        Country country = this.countryRepository.findById(id).orElseThrow(InvalidCountryException::new);
        return country;
    }

    @Override
    public Country Create(String name, String continent) {
        Country country = new Country(name, continent);
        return this.countryRepository.save(country);
    }

    @Override
    public Country Update(Long id, String name, String continent) {
        Country country = this.countryRepository.findById(id).orElseThrow(InvalidCountryException::new);
        country.setName(name);
        country.setContinent(continent);
        return this.countryRepository.save(country);
    }

    @Override
    public Country Delete(Long id) {
        Country country = this.countryRepository.findById(id).orElseThrow(InvalidCountryException::new);
        this.countryRepository.delete(country);
        return country;
    }
}
