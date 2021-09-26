package by.Matveev.dao;

import by.Matveev.entity.User;
import by.Matveev.service.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class HibernateUser implements UserDao {
    @Override
    public List<User> getUsers() {
        List<User> users = null;
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            users = session.createQuery("FROM User", User.class).list();
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void addUser(User user) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void changePassword(User user, String password) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user1 = session.get(User.class, user.getId());
            user1.setPassword(password);
            session.update(user1);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public boolean isExist(User user) {
        Transaction transaction = null;
        boolean flag = false;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Optional<User> optionalUser = session.createQuery("FROM User where login = : login", User.class)
                    .setParameter("login", user.getLogin())
                    .uniqueResultOptional();
            if(optionalUser.isPresent()){
                if(user.equals(optionalUser.get())) {
                    flag = true;
                }
            }
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public User getUserByLogin(String login) {
        User user = new User();
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            user = session.createQuery("FROM User WHERE login = : login", User.class)
                    .setParameter("login", login)
                    .getSingleResult();
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }
}
