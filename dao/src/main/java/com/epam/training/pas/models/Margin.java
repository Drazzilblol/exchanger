package com.epam.training.pas.models;

import java.util.Date;

/**
 * Created by Drazz on 30.11.2015.
 */
public class Margin {
    private Long id;
    private Long currencyId;
    private Double value;
    private Date creationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Margin margin = (Margin) o;

        if (id != null ? !id.equals(margin.id) : margin.id != null) return false;
        if (currencyId != null ? !currencyId.equals(margin.currencyId) : margin.currencyId != null) return false;
        if (value != null ? !value.equals(margin.value) : margin.value != null) return false;
        return !(creationDate != null ? !creationDate.equals(margin.creationDate) : margin.creationDate != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (currencyId != null ? currencyId.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
