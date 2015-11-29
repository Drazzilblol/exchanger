package com.epam.training.pas.dao;

import com.epam.training.pas.models.Country;
import com.epam.training.pas.models.User;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public interface CountryDao {

    List<Country> getCountryList();

    Country getCountry(Long id);

    Long save(Country country);

    void update(Country country);

    int delete(Long countryId);

}
