package com.epam.training.pas.models;

/**
 * Created by Drazz on 20.11.2015.
 */
public class Country {
    private Long id;
    private String name;
    private String countryCode;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
