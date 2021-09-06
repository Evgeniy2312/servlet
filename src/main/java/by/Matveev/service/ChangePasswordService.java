package by.Matveev.service;

import by.Matveev.dao.HibernateUser;
import by.Matveev.dao.UserDao;
import by.Matveev.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChangePasswordService{
    private static final Logger logger = LoggerFactory.getLogger(ChangePasswordService.class);
    private UserDao userDao;

    public ChangePasswordService(HibernateUser hibernateUser){
        this.userDao = hibernateUser;
    }

    public void changePassword(User user, String password){
        userDao.changePassword(user, password);
        logger.info("User with name {} changed password", user.getName());
    }
}
