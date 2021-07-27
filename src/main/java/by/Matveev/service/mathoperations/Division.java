package by.Matveev.service.mathoperations;

import by.Matveev.entity.Operation;

public class Division implements MathOperation{
    private String name = "div";

    @Override
    public Operation getResult(double...i) {
        return new Operation(i[0], i[1], name, (i[0] / i[1]));
    }
}
