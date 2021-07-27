package by.Matveev.service.mathoperations;

import by.Matveev.entity.Operation;

public class Multiplication implements MathOperation{
    private String name = "mul";
    @Override
    public Operation getResult(double... a) {
        return new Operation(a[0], a[1], name, (a[0] * a[1] ));
    }
}
