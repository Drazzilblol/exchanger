package com.epam.training.pas.models;

/**
 * Created by Drazz on 16.11.2015.
 */
public class Currency {
    private int id;
    private String name;
    private String currencyCode;
    private Double sale;
    private int buy;

    public Currency(int id, String name, String currencyCode, Double sale, int buy) {
        this.id = id;
        this.name = name;
        this.currencyCode = currencyCode;
        this.sale = sale;
        this.buy = buy;
    }

    public Currency() {
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

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }
}
