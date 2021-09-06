package by.Matveev.service;

import by.Matveev.entity.Operation;
import by.Matveev.entity.User;
import by.Matveev.service.mathoperations.MapOperations;
import by.Matveev.service.mathoperations.operations.MathOperation;


public class CalculateService {

    public double getDouble(Operation operation){
        MathOperation mathOperation = MapOperations.OPERATIONS_MAP.get(operation.getOperation());
        double result = mathOperation.getResult(operation.getUser(), operation.getI1(), operation.getI2());
        operation.setResult(result);
        return result;
    }
}

//
//    MathOperation mathOperation = MapOperations.OPERATIONS_MAP.get(type);
//    double result = mathOperation.getResult(user, i[0], i[1]);
//        operation.setResult(result);
//                return result;