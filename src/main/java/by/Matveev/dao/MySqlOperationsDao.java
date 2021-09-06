package by.Matveev.dao;

import by.Matveev.connector.ConnectorManager;
import by.Matveev.entity.Operation;
import by.Matveev.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlOperationsDao implements RememberingInformationDao{
    private  static int NUM_ONE = 1;
    private  static int NUM_TWO = 2;
    private  static int TYPE_OPERATION = 3;
    private  static int RESULT = 4;
    private  static int USER_LOGIN = 4;
    private  static String SAVE = "INSERT INTO operation(number1, number2, type_of_operation, result, user_login) VALUES (?, ?, ?, ?, ?)";
    private  static String SELECT = "SELECT * FROM operation  LEFT JOIN users on operation.user_login = users.login";
    private  static String BY_USER = "WHERE user_login = ?";
    private  static String BY_TYPE = "WHERE user_login = ? AND type_of_operation = ?";


    @Override
    public void addOperation(Operation operation) {
        try(Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE);
            preparedStatement.setDouble(NUM_ONE, operation.getI1());
            preparedStatement.setDouble(NUM_TWO, operation.getI2());
            preparedStatement.setString(TYPE_OPERATION, operation.getOperation());
            preparedStatement.setDouble(RESULT, operation.getResult());
            preparedStatement.setString(USER_LOGIN, operation.getUser().getLogin());
            preparedStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Operation> getOperations() {
        List<Operation> operations = new ArrayList<>();
        try(Connection connection = ConnectorManager.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);
            array(operations, resultSet);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return operations;
    }

    @Override
    public List<Operation> getOperationBySession(User user) {
        List<Operation> operations = new ArrayList<>();
        try(Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT + BY_USER);
            preparedStatement.setString(USER_LOGIN, user.getLogin());
            ResultSet resultSet = preparedStatement.executeQuery();
            array(operations, resultSet);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return operations;
    }

    private void array (List<Operation> operations, ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            operations.add(new Operation(
                    resultSet.getDouble("number1"),
                    resultSet.getDouble("number2"),
                    resultSet.getString("type_of_operation"),
                    resultSet.getDouble("result"),
                    new User(resultSet.getString("login"),
                            resultSet.getString("password"),
                            resultSet.getString("name"))
            ));
        }
    }

    @Override
    public List<Operation> getOperationByNameOfFunctions(User user, String name) {
        List<Operation> operations = new ArrayList<>();
        try(Connection connection = ConnectorManager.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT  + BY_TYPE);
            preparedStatement.setString(USER_LOGIN, user.getLogin());
            preparedStatement.setString(TYPE_OPERATION, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            array(operations, resultSet);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return operations;
    }
}
