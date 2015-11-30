package com.epam.training.pas.services.impl;

import com.epam.training.pas.dao.MarginDao;
import com.epam.training.pas.models.Margin;
import com.epam.training.pas.services.MarginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Drazz on 30.11.2015.
 */
@Service
public class MarginServiceImpl implements MarginService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperationServiceImpl.class);

    @Autowired
    private MarginDao marginDao;

    @Override
    public List<Margin> geMargins() {
        return marginDao.geMargins();
    }

    @Override
    public Margin getMarginById(Long id) {
        return marginDao.getMarginById(id);
    }

    @Override
    public List<Margin> getMarginsByCurrencyId(Long currencyId) {
        return marginDao.getMarginsByCurrencyId(currencyId);
    }

    @Override
    public Long save(Margin margin) {
        LOGGER.info("Save margin: id {}, value {}", margin.getId(), margin.getValue());
        return marginDao.save(margin);
    }

    @Override
    public void update(Margin margin) {
        LOGGER.info("Update margin: id {}, value {}", margin.getId(), margin.getValue());
        marginDao.update(margin);

    }

    @Override
    public int delete(Long marginId) {
        LOGGER.info("Delete margin with id {}", marginId);
        return marginDao.delete(marginId);
    }

    @Override
    public Double calculateTotalMargin(List<Margin> margins) {
        Double totalMargin = 0.0;
        for (Margin margin : margins) {
            totalMargin += margin.getValue();
        }
        return totalMargin;
    }
}
