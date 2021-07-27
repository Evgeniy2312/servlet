package by.Matveev.service;

import by.Matveev.entity.Operation;

public class ControllerCalculationImpl implements ControllerCalculation {
    @Override
    public  Operation getResult(double i1, double i2, String calculation) {
        double result = 0;
        switch (calculation){
            case "add" : result =  i1 + i2;
                break;
            case "sub": result = i1 - i2;
                break;
            case "mul": result = i1 * i2;
                break;
            case "div": result = i1 / i2;
                break;
        }
        Operation operation = new Operation(i1, i2, calculation, result);
        return operation;
    }
}
