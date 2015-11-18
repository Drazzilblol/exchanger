package com.epam.training.pas.models;

/**
 * Created by Drazz on 18.11.2015.
 */
public class Account {
    private int id;
    private String name;
    private int currencyId;
    private int userId;
    private Double value;

    public Account(int id, String name, int currencyId, int userId, Double value) {
        this.id = id;
        this.name = name;
        this.currencyId = currencyId;
        this.userId = userId;
        this.value = value;
    }

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
