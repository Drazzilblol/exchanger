package com.epam.training.pas.services.impl;

import com.epam.training.pas.dao.CountryDao;
import com.epam.training.pas.models.Country;
import com.epam.training.pas.services.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
@Service
public class CountryServiceImpl implements CountryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyServiceImpl.class);

    @Autowired
    private CountryDao countryDao;

    @Override
    public List<Country> geCountries() {
        return countryDao.getCountryList();
    }

    @Override
    public Country getCountryById(Long id) {
        return countryDao.getCountry(id);
    }

    @Override
    public Long save(Country country) {
        LOGGER.info("Save country {}", country.getName());
        return countryDao.save(country);
    }

    @Override
    public void update(Country country) {
        LOGGER.info("Update country {}", country.getName());
        countryDao.update(country);
    }

    @Override
    public int delete(Long countryId) {
        LOGGER.info("Delete country with id = {}", countryId);
       return countryDao.delete(countryId);
    }
}
