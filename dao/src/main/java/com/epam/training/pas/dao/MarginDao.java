package com.epam.training.pas.dao;

import com.epam.training.pas.models.Margin;

import java.util.List;

/**
 * Created by Drazz on 30.11.2015.
 */
public interface MarginDao {
    List<Margin> geMargins();

    Margin getMarginById(Long id);

    List<Margin> getMarginsByCurrencyId(Long currencyId);

    Long save(Margin margin);

    void update(Margin margin);

    int delete(Long marginId);
}
