package by.Matveev.dao;

import by.Matveev.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListUser implements UserDao {

    private static final List<User> users = new ArrayList<>();


    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        getUsers().add(user);
    }

    @Override
    public void changePassword(User user, String password) {
        user.setPassword(password);
    }


}
