package com.epam.training.pas.dao;

import com.epam.training.pas.models.Country;
import com.epam.training.pas.models.User;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public interface CountryDao {

    List<Country> getCountryList();

    Country getCountry(int id);

    void save(Country country);

    void delete(int countryId);

}
