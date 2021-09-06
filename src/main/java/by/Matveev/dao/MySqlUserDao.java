package by.Matveev.dao;

import by.Matveev.connector.ConnectorManager;
import by.Matveev.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserDao implements UserDao{

    private static int LOGIN = 1;
    private static int PASSWORD = 2;
    private static int NAME = 3;
    private static String ALL_USERS = "SELECT * FROM users";
    private static String SAVE = "INSERT INTO users(login, password, name) VALUES (?, ?, ?)";
    private static String UPDATE = "UPDATE users SET password = ? WHERE login = ?";



    @Override
    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        try(Connection connection = ConnectorManager.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(ALL_USERS);
            while (resultSet.next()){
                userList.add(new User(resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("name")
                        ));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return userList;
    }

    @Override
    public void addUser(User user) {
        try(Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE);
            preparedStatement.setString(LOGIN, user.getLogin());
            preparedStatement.setString(PASSWORD, user.getPassword());
            preparedStatement.setString(NAME, user.getName());
            preparedStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void changePassword(User user, String password) {
        try(Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(PASSWORD, password);
            preparedStatement.setString(LOGIN, user.getLogin());
            preparedStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
