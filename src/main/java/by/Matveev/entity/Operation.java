package by.Matveev.entity;

import java.util.Objects;

public class Operation {
    private double i1;
    private double i2;
    private String operation;
    private double result;
    private User user;

    public Operation(double i1, double i2, String operation, double result) {
        this.i1 = i1;
        this.i2 = i2;
        this.operation = operation;
        this.result = result;
    }

    public double getI1() {
        return i1;
    }

    public void setI1(double i1) {
        this.i1 = i1;
    }

    public double getI2() {
        return i2;
    }

    public void setI2(double i2) {
        this.i2 = i2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "number1 - " + i1 + "; number2 - " + i2 + "; operation - " + operation + "; result - "
        + result + "; name - " + user.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation1 = (Operation) o;
        return i1 == operation1.i1 && i2 == operation1.i2 && result == operation1.result && Objects.equals(operation, operation1.operation) && Objects.equals(user, operation1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i1, i2, operation, result, user);
    }
}
