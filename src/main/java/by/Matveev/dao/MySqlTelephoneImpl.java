package by.Matveev.dao;

import by.Matveev.connector.ConnectorManager;
import by.Matveev.entity.Address;
import by.Matveev.entity.Telephone;
import by.Matveev.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlTelephoneImpl implements TelephoneDao {


    private static int NUMBER = 1;
    private static int USER_ID = 2;
    private static int IS_PRIMARY = 3;
    private static String CHECK = "SELECT * FROM telephones LEFT JOIN users u on u.id = telephones.user_id " +
            "WHERE number = ? AND user_id = ?";
    private static String SAVE = "INSERT INTO telephones(NUMBER, is_primary, user_id) VALUES (?, ?, ?)";
    private static String IS_EXIST = "SELECT * FROM telephones LEFT JOIN users u on u.id = telephones.user_id WHERE telephones.id = ? AND user_id = ?";
    private static String UPDATE = "UPDATE telephones SET number = ? WHERE user_id = ? AND id  = ?";
    private static String GET_ALL = "SELECT * FROM telephones LEFT JOIN users u on u.id = telephones.user_id";
    private static String REMOVE = "DELETE FROM telephones where id = ? AND user_id = ?";
    private static String GET_BY_ID = "SELECT * FROM telephones WHERE id = ?";

    @Override
    public void addTelephone(Telephone telephone) {
        try (Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE);
            preparedStatement.setLong(1, telephone.getNumber());
            preparedStatement.setBoolean(2, telephone.isPrimary());
            preparedStatement.setLong(3, telephone.getUser().getId());
            preparedStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteTelephone(Telephone telephone) {
        try (Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE);
            preparedStatement.setLong(1, telephone.getId());
            preparedStatement.setLong(2, telephone.getUser().getId());
            preparedStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void updateTelephone(Telephone telephone, long num) {
        try (Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setLong(1, num);
            preparedStatement.setLong(2, telephone.getUser().getId());
            preparedStatement.setLong(3, telephone.getId());

            preparedStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Telephone> getTelephones() {
        List<Telephone> telephones = new ArrayList<>();
        try (Connection connection = ConnectorManager.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            getListOfTelephones(telephones, resultSet);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return telephones;
    }

    private void getListOfTelephones(List<Telephone> telephones, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            telephones.add(new Telephone(resultSet.getLong("id"),
                    resultSet.getLong("number"),
                    new User(resultSet.getLong("user_id"),
                            resultSet.getString("name"),
                            resultSet.getString("login"),
                            resultSet.getString("password")
                    )
            ));
        }
    }

    @Override
    public boolean check(Telephone telephone) {
        try (Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK);
            preparedStatement.setLong(1, telephone.getNumber());
            preparedStatement.setLong(2, telephone.getUser().getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isExist(Telephone telephone) {
        try (Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(IS_EXIST);
            preparedStatement.setLong(1, telephone.getId());
            preparedStatement.setLong(2, telephone.getUser().getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public Telephone getById(Telephone telephone) {
        Telephone telephone1 =new Telephone();
        try (Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID);
            preparedStatement.setLong(1, telephone.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                telephone1.setId(resultSet.getLong("id"));
                telephone1.setNumber(resultSet.getLong("number"));
                telephone1.setUser(telephone.getUser());
                telephone1.setPrimary(resultSet.getBoolean("is_primary"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return telephone1;
    }
}
