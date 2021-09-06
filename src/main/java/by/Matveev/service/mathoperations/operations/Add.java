package by.Matveev.service.mathoperations.operations;

import by.Matveev.entity.Operation;
import by.Matveev.entity.User;

public class Add implements MathOperation{
    private String name = "add";
    @Override
    public double getResult(User user, double... a) {
        return new Operation(a[0], a[1], name, getDouble(a[0] + a[1]), user).getResult();
    }
}
