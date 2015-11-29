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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operation operation = (Operation) o;

        if (id != null ? !id.equals(operation.id) : operation.id != null) return false;
        if (currencyFromId != null ? !currencyFromId.equals(operation.currencyFromId) : operation.currencyFromId != null)
            return false;
        if (currencyToId != null ? !currencyToId.equals(operation.currencyToId) : operation.currencyToId != null)
            return false;
        if (accountFromId != null ? !accountFromId.equals(operation.accountFromId) : operation.accountFromId != null)
            return false;
        if (accountToId != null ? !accountToId.equals(operation.accountToId) : operation.accountToId != null)
            return false;
        if (date != null ? !date.equals(operation.date) : operation.date != null) return false;
        if (currencySell != null ? !currencySell.equals(operation.currencySell) : operation.currencySell != null)
            return false;
        return !(currencyBuy != null ? !currencyBuy.equals(operation.currencyBuy) : operation.currencyBuy != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (currencyFromId != null ? currencyFromId.hashCode() : 0);
        result = 31 * result + (currencyToId != null ? currencyToId.hashCode() : 0);
        result = 31 * result + (accountFromId != null ? accountFromId.hashCode() : 0);
        result = 31 * result + (accountToId != null ? accountToId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (currencySell != null ? currencySell.hashCode() : 0);
        result = 31 * result + (currencyBuy != null ? currencyBuy.hashCode() : 0);
        return result;
    }
}