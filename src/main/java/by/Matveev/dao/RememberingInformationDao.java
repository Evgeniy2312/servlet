package by.Matveev.dao;

import by.Matveev.entity.Operation;

import java.util.List;

public interface RememberingInformationDao {
    List<Operation> getOperations();

    List<Operation> getOperationByLogin(String login);

    List<Operation> getOperationByNameOfFunctions(String name);
}