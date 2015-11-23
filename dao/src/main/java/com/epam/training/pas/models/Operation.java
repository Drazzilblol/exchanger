package com.epam.training.pas.models;

import java.util.Date;

/**
 * Created by Drazz on 18.11.2015.
 */
public class Operation {
    private Long id;
    private Long currencyFromId;
    private Long currencyToId;
    private Long accountFromId;
    private Long accountToId;
    private Date date;
    private Double currencySell;
    private Double currencyBuy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCurrencyFromId() {
        return currencyFromId;
    }

    public void setCurrencyFromId(Long currencyFromId) {
        this.currencyFromId = currencyFromId;
    }

    public Long getCurrencyToId() {
        return currencyToId;
    }

    public void setCurrencyToId(Long currencyToId) {
        this.currencyToId = currencyToId;
    }

    public Long getAccountFromId() {
        return accountFromId;
    }

    public void setAccountFromId(Long accountFromId) {
        this.accountFromId = accountFromId;
    }

    public Long getAccountToId() {
        return accountToId;
    }

    public void setAccountToId(Long accountToId) {
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