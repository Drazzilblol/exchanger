package com.epam.training.pas.services;

import com.epam.training.pas.models.Operation;
import com.epam.training.pas.models.User;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public interface OperationService {
    public List<Operation> getOperations();

    public Operation getOperationById(Long id);

    public Long save(Operation operation);

    public void update(Operation operation);

    public int delete(Long operationId);

    public int deleteByAccountId(Long accountId);
}
