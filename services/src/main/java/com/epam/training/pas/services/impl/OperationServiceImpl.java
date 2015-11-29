package com.epam.training.pas.services.impl;

import com.epam.training.pas.dao.OperationDao;
import com.epam.training.pas.models.Operation;
import com.epam.training.pas.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public class OperationServiceImpl implements OperationService {
    @Autowired
    private OperationDao operationDao;

    @Override
    public List<Operation> getOperations() {
        return operationDao.getOperations();
    }

    @Override
    public Operation getOperationById(int id) {
        return operationDao.getOperationById(id);
    }

    @Override
    public void save(Operation operation) {
        operationDao.save(operation);
    }

    @Override
    public void delete(int operationId) {
        operationDao.delete(operationId);
    }
}
