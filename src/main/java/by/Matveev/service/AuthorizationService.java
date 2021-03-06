package by.Matveev.service;

import by.Matveev.dao.*;
import by.Matveev.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class AuthorizationService {
    private UserDao userDao;
    private static final Logger logger = LoggerFactory.getLogger(AuthorizationService.class);

    public AuthorizationService(HibernateUser hibernateUser){
        this.userDao = hibernateUser ;
    }

    public Optional<User> logIn(User user) {
        if (userDao.isExist(user)){
            User user1 = userDao.getUserByLogin(user.getLogin());
            logger.info("User with name {} authorized ", user1.getName());
            return Optional.of(user1);
        }else {
            logger.warn("User with login {} try to authorized without registration",user.getLogin() );
            return Optional.empty();
        }
    }

}
