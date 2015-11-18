package com.epam.training.pas.models;

import java.util.Date;

/**
 * Created by Drazz on 18.11.2015.
 */
public class Operation {
    private int id;
    private int currencyFromId;
    private int currencyToId;
    private int accountFromId;
    private int accountToId;
    private Date date;
    private Double currencySell;
    private Double currencyBuy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrencyFromId() {
        return currencyFromId;
    }

    public void setCurrencyFromId(int currencyFromId) {
        this.currencyFromId = currencyFromId;
    }

    public int getCurrencyToId() {
        return currencyToId;
    }

    public void setCurrencyToId(int currencyToId) {
        this.currencyToId = currencyToId;
    }

    public int getAccountFromId() {
        return accountFromId;
    }

    public void setAccountFromId(int accountFromId) {
        this.accountFromId = accountFromId;
    }

    public int getAccountToId() {
        return accountToId;
    }

    public void setAccountToId(int accountToId) {
        this.accountToId = accountToId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getCurrencySell() {
        return currencySell;
    }

    public void setCurrencySell(Double currencySell) {
        this.currencySell = currencySell;
    }

    public Double getCurrencyBuy() {
        return currencyBuy;
    }

    public void setCurrencyBuy(Double currencyBuy) {
        this.currencyBuy = currencyBuy;
    }
}