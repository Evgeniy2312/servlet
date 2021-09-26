package by.Matveev.service;

import by.Matveev.dao.HibernateUser;
import by.Matveev.dao.ListUser;
import by.Matveev.dao.MySqlUserImpl;
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

    public boolean changePassword(User user, String password){
        if(userDao.isExist(user)) {
            userDao.changePassword(user, password);
            logger.info("User with name {} changed password", user.getName());
            return true;
        }else return false;
    }
}
