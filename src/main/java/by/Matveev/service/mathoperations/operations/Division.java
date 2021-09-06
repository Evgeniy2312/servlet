package by.Matveev.service.mathoperations.operations;

import by.Matveev.entity.Operation;
import by.Matveev.entity.User;

public class Division implements MathOperation{
    private String name = "div";

    @Override
    public double getResult(User user, double...i) {
        return new Operation(i[0], i[1], name, getDouble(i[0] / i[1]), user).getResult();
    }
}
