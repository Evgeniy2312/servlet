package by.Matveev.dao;

import by.Matveev.entity.Operation;
import by.Matveev.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ListOperations implements RememberingInformationDao {
    private final static List<Operation> operations = new ArrayList<>();

    @Override
    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public void addOperation(Operation operation) {
        getOperations().add(operation);
    }

    @Override
    public List<Operation> getOperationBySession(User user) {
        List<Operation> operations = new ArrayList<>();
        for (Operation operation : getOperations()) {
            if (operation.getUser().equals(user)) {
                operations.add(operation);
            }
        }
        return operations;
    }

    @Override
    public List<Operation> getOperationByNameOfFunctions(User user, String name) {
        List<Operation> operations = new ArrayList<>();
        for (Operation operation : getOperations()) {
            if (operation.getUser().equals(user)) {
                if (operation.getOperation().equals(name)) {
                    operations.add(operation);
                }
            }
        }
        return operations;
    }
}