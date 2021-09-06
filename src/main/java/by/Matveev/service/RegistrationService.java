package by.Matveev.service;

import by.Matveev.dao.HibernateUser;
import by.Matveev.dao.ListUser;
import by.Matveev.dao.MySqlUserDao;
import by.Matveev.dao.UserDao;
import by.Matveev.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RegistrationService {
    private UserDao userDao;
    private static final Logger logger = LoggerFactory.getLogger(RegistrationService.class);

    public RegistrationService(HibernateUser hibernateUser){
        this.userDao = hibernateUser;
    }

    public boolean addUser(User user) {
        if (!userDao.getUsers().contains(user)) {
            userDao.addUser(user);
            logger.info("User with name {} created", user.getName());
            return true;
        } else {
            logger.warn("User with login {} try to registered", user.getLogin());
            return false;
        }
    }
}
