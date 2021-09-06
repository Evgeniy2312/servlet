package by.Matveev.service.mathoperations.operations;

import by.Matveev.entity.Operation;
import by.Matveev.entity.User;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface MathOperation {
    double getResult(User user, double...a);
    default double getDouble(double result){
        BigDecimal resultBD = new BigDecimal(result).setScale(2, RoundingMode.DOWN);
        return resultBD.doubleValue();
    }
}
