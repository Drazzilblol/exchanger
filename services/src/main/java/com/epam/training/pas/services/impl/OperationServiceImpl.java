package com.epam.training.pas.services.impl;

import com.epam.training.pas.dao.CurrencyDao;
import com.epam.training.pas.dao.OperationDao;
import com.epam.training.pas.models.Operation;
import com.epam.training.pas.services.OperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
@Service
public class OperationServiceImpl implements OperationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperationServiceImpl.class);

    @Autowired
    private OperationDao operationDao;
    @Autowired
    private CurrencyDao currencyDao;

    @Override
    public List<Operation> getOperations() {
        return operationDao.getOperations();
    }

    @Override
    public Operation getOperationById(Long id) {
        return operationDao.getOperationById(id);
    }

    @Override
    public Long save(Operation operation) {
        LOGGER.info("Account {}(-{} {}) -> Account {}(+{} {})", operation.getAccountFromId(), operation.getCurrencySell(),
                currencyDao.getCurrencyById(operation.getCurrencyFromId()).getCurrencyCode(), operation.getAccountToId(),
                operation.getCurrencyBuy(), currencyDao.getCurrencyById(operation.getCurrencyToId()).getCurrencyCode());
        return operationDao.save(operation);
    }

    @Override
    public void update(Operation operation) {
        LOGGER.info("Operation from account {} to account {} update", operation.getAccountFromId(), operation.getAccountToId());
        operationDao.update(operation);
    }

    @Override
    public int delete(Long operationId) {
        LOGGER.info("Delete operation with id = {}", operationId);
        return operationDao.delete(operationId);
    }

    @Override
    public int deleteByAccountId(Long accountId) {
        LOGGER.info("Delete all operations with accountId = {}", accountId);
        return operationDao.deleteByAccountId(accountId);
    }

    @Override
    public int deleteByCurrencyId(Long currencyId) {
        LOGGER.info("Delete all operations with accountId = {}", currencyId);
        return operationDao.deleteByCurrencyId(currencyId);
    }
}
