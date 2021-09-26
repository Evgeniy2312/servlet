package by.Matveev.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQueries({@NamedQuery(name = "Operation.allOperations", query = "From Operation"),
        @NamedQuery(name = "Operation.allOperationsByUser", query = "FROM Operation  WHERE user =: user"),
        @NamedQuery(name = "Operation.allOperationsByTypeOfOperation", query = "FROM Operation  WHERE user =: user AND typeOfOperation =: type ")
})
@Table( schema = "hibernate", name = "operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double i1;
    private double i2;
    private String typeOfOperation;
    private double result;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    public Operation(double i1, double i2, String operation, double result,User user) {
        this.i1 = i1;
        this.i2 = i2;
        this.typeOfOperation = operation;
        this.result = result;
        this.user = user;
    }

    public Operation(double i1, double i2, String operation, User user) {
        this.i1 = i1;
        this.i2 = i2;
        this.typeOfOperation = operation;
        this.user = user;
    }

    public Operation() {
    }

    public static Operation returnOperation(double i1, double i2, String operation, User user){
        return new Operation(i1, i2, operation, user);
    }

    public long getId() {
        return id;
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
        return typeOfOperation;
    }

    public void setOperation(String operation) {
        this.typeOfOperation = operation;
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
        return "number1 - " + i1 + "; number2 - " + i2 + "; operation - " + typeOfOperation + "; result - "
        + result + "; name - " + user.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation1 = (Operation) o;
        return i1 == operation1.i1 && i2 == operation1.i2 && result == operation1.result && Objects.equals(typeOfOperation, operation1.typeOfOperation) && Objects.equals(user, operation1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i1, i2, typeOfOperation, result, user);
    }
}
