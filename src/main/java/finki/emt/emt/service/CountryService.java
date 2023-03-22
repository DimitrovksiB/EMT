package finki.emt.emt.service;

import finki.emt.emt.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> listAll();
    Country findById(Long id);
    Country Create(String name, String continent);
    Country Update(Long id, String name, String continent );
    Country Delete(Long id);
}
