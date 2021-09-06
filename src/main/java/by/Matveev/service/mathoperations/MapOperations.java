package by.Matveev.service.mathoperations;

import by.Matveev.service.mathoperations.operations.*;

import java.util.HashMap;
import java.util.Map;

public class MapOperations {
    public final static Map<String, MathOperation> OPERATIONS_MAP = new HashMap<>();

    static {
        OPERATIONS_MAP.put("add", new Add());
        OPERATIONS_MAP.put("div", new Division());
        OPERATIONS_MAP.put("sub", new Subtraction());
        OPERATIONS_MAP.put("mul", new Multiplication());
    }
}
