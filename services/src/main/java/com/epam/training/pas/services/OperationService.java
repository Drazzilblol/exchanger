package com.epam.training.pas.services;

import com.epam.training.pas.models.Operation;
import com.epam.training.pas.models.User;

import java.util.List;

/**
 * Created by Drazz on 23.11.2015.
 */
public interface OperationService {
    public List<Operation> getOperations();

    public Operation getOperationById(int id);

    public void save(Operation operation);

    public void delete(int operationId);
}
