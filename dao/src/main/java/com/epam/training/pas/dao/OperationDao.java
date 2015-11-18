package com.epam.training.pas.dao;

import com.epam.training.pas.models.Operation;
import com.epam.training.pas.models.User;

import java.util.List;

/**
 * Created by Drazz on 18.11.2015.
 */
public interface OperationDao {
    List<Operation> getOperations();

    Operation getOperationById(int id);

    void save(Operation operation);

    void delete(Operation operation);
}
