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
        users.add(new User(users.size() + 1, user.getName(), user.getLogin(), user.getPassword()));
    }

    @Override
    public void changePassword(User user, String password) {
        User user1 = users.get(users.indexOf(user));
        user1.setPassword(password);
    }

    @Override
    public boolean isExist(User user) {
        return users.contains(user);
    }

    @Override
    public User getUserByLogin(String login) {
        User user = new User();
        for(User user1 : users){
            if(user1.getLogin().equals(login)){
                user = user1;
            }
        }
        return user;
    }


}
