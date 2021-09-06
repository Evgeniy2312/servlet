package by.Matveev.dao;

import by.Matveev.entity.Operation;
import by.Matveev.entity.User;

import java.util.List;

public interface RememberingInformationDao {
    void addOperation(Operation operation);

    List<Operation> getOperations();

    List<Operation> getOperationBySession(User user);

    List<Operation> getOperationByNameOfFunctions(User user, String name);
}