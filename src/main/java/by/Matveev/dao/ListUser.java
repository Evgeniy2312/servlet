package by.Matveev.dao;

import by.Matveev.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ListUser implements UserDao{

    private static final List<User> USERS = new ArrayList<>();


    @Override
    public List<User> getUser() {
        return USERS;
    }

    @Override
    public boolean addUser(User user) {
        boolean flag = false;
        if(!getUser().contains(user)){
            getUser().add(user);
            flag = true;
        }
        return flag;
    }
}