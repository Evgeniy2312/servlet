package by.Matveev.dao;

import by.Matveev.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    public List<User> getUsers();
    void addUser(User user);
    void changePassword(User user, String password);
}
