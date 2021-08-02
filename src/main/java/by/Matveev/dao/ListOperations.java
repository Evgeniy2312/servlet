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
    public List<Operation> getOperationByLogin(String login) {
        if(new ListUser().getUser().contains(new User(login))) {
            List<Operation> operations = new ArrayList<>();
            for (Operation operation : getOperations()) {
                if (operation.getUser().getLogin().equals(login)) {
                    operations.add(operation);
                }
            }
            return operations;
        }
        return null;
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
