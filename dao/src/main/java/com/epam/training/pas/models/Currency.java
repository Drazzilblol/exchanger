package com.epam.training.pas.models;

/**
 * Created by Drazz on 16.11.2015.
 */
public class Currency {
    private Long id;
    private String name;
    private String currencyCode;
    private Double sale;
    private Double buy;


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

    public Double getBuy() {
        return buy;
    }

    public void setBuy(Double buy) {
        this.buy = buy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        if (id != null ? !id.equals(currency.id) : currency.id != null) return false;
        if (name != null ? !name.equals(currency.name) : currency.name != null) return false;
        if (currencyCode != null ? !currencyCode.equals(currency.currencyCode) : currency.currencyCode != null)
            return false;
        if (sale != null ? !sale.equals(currency.sale) : currency.sale != null) return false;
        return !(buy != null ? !buy.equals(currency.buy) : currency.buy != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (currencyCode != null ? currencyCode.hashCode() : 0);
        result = 31 * result + (sale != null ? sale.hashCode() : 0);
        result = 31 * result + (buy != null ? buy.hashCode() : 0);
        return result;
    }
}
