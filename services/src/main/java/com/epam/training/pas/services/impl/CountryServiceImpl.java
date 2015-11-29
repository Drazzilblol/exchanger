package com.epam.training.pas.services.impl;

import com.epam.training.pas.dao.CountryDao;
import com.epam.training.pas.models.Country;
import com.epam.training.pas.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDao countryDao;

    @Override
    public List<Country> geCountries() {
        return countryDao.getCountryList();
    }

    @Override
    public Country getCountryById(int id) {
        return countryDao.getCountry(id);
    }

    @Override
    public void save(Country country) {
        countryDao.save(country);
    }

    @Override
    public void delete(int countryId) {
        countryDao.delete(countryId);

    }
}
