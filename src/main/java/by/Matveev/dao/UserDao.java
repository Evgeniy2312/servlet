package by.Matveev.dao;

import by.Matveev.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> getUser();
    boolean addUser(User user);

}
