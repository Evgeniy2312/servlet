package by.Matveev.dao;

import by.Matveev.connector.ConnectorManager;
import by.Matveev.entity.Address;
import by.Matveev.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlAddressImpl implements AddressDao {

    private static int NUMBER = 1;
    private static int STREET = 2;
    private static int IS_PRIMARY = 3;
    private static int USER_ID = 4;
    private static String GET_BY_ID = "SELECT * FROM addresses LEFT JOIN users u on u.id = addresses.user_id WHERE " +
            "addresses.number = ? and addresses.street = ? and addresses.user_id = ?";
    private static String CHECK = "SELECT * FROM addresses LEFT JOIN users u on u.id = addresses.user_id WHERE addresses.id = ? AND addresses.user_id = ? ";
    private static String GET_ADDRESS = "SELECT * FROM addresses WHERE id = ?";
    private static String SAVE = "INSERT INTO addresses(NUMBER, STREET, IS_PRIMARY, USER_ID) VALUES (?, ?, ?, ?)";
    private static String DELETE = "DELETE FROM addresses WHERE id = ? AND user_id = ?";
    private static String UPDATE = "UPDATE addresses SET number = ?, street = ? WHERE id = ? AND user_id = ?";
    private static String GET_ALL = "SELECT * FROM addresses LEFT JOIN users u on u.id = addresses.user_id";


    @Override
    public void addAddress(Address address) {
        try (Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE);
            preparedStatement.setInt(1, address.getNumber());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setBoolean(3, address.isPrimary());
            preparedStatement.setLong(4, address.getUser().getId());
            preparedStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteAddress(Address address) {
        try (Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setLong(1, address.getId());
            preparedStatement.setLong(2, address.getUser().getId());
            preparedStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void updateAddress(Address address, String street, int num) {
        try (Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, num);
            preparedStatement.setString(2, street);
            preparedStatement.setLong(3, address.getId());
            preparedStatement.setLong(4, address.getUser().getId());
            preparedStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Address> getAddresses() {
        List<Address> addresses = new ArrayList<>();
        try (Connection connection = ConnectorManager.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            getListOfAddresses(addresses, resultSet);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return addresses;
    }

    private void getListOfAddresses(List<Address> addresses, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            addresses.add(new Address(resultSet.getLong("id"),
                    resultSet.getInt("number"),
                    resultSet.getString("street"),
                    new User(resultSet.getLong("user_id"),
                            resultSet.getString("name"),
                            resultSet.getString("login"),
                            resultSet.getString("password")

                    )
            ));
        }
    }

    @Override
    public boolean check(Address address) {
        try (Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID);
            preparedStatement.setInt(1, address.getNumber());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setLong(3, address.getUser().getId());
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
    public boolean isExist(Address address) {
        try (Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK);
            preparedStatement.setLong(1, address.getId());
            preparedStatement.setLong(2,  address.getUser().getId());
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
    public Address getById(Address address) {
        Address address1 = new Address();
        try (Connection connection = ConnectorManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ADDRESS);
            preparedStatement.setLong(1, address.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                address1.setId(resultSet.getLong("id"));
                address1.setStreet(resultSet.getString("street"));
                address1.setNumber(resultSet.getInt("number"));
                address1.setUser(address.getUser());
                address1.setPrimary(resultSet.getBoolean("is_primary"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return address1;
    }
}
