package by.Matveev.dao;

import by.Matveev.entity.Operation;
import by.Matveev.entity.User;
import by.Matveev.service.input.Input;

import java.util.ArrayList;
import java.util.List;

public class ListOperations implements RememberingInformationDao {
    private final static List<Operation> operations = new ArrayList<>();

    @Override
    public List<Operation> getOperations() {
        return operations;
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
    public List<Operation> getOperationByNameOfFunctions(String name) {
        List<Operation> operations = new ArrayList<>();
        if (Input.checkTypeOfCalculation(name)) {
            for (Operation operation : getOperations()) {
                if (operation.getOperation().equals(name)) {
                    operations.add(operation);
                }
            }
            return operations;
        }
        return null;
    }
}
