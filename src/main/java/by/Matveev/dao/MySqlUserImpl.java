package by.Matveev.dao;

import by.Matveev.connector.ConnectorManager;
import by.Matveev.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class
MySqlUserImpl implements UserDao{

    private static int LOGIN = 1;
    private static int PASSWORD = 2;
    private static int NAME = 3;
    private static String ALL_USERS = "SELECT * FROM users";
    private static String SAVE = "INSERT INTO users(login, password, name) VALUES (?, ?, ?)";
    private static String UPDATE = "UPDATE users SET password = ? WHERE login = ?";
    private static String GET_BY_LOGIN ="SELECT * FROM users WHERE login = ?";



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
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void changePassword(User user, String password) {
        try(Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public boolean isExist(User user) {
        try(Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_LOGIN);
            preparedStatement.setString(1, user.getLogin());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUserByLogin(String login) {
        User user= new User();
        try(Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return user;
    }
}
