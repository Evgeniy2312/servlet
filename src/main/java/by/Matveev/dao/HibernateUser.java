package by.Matveev.dao;

import by.Matveev.entity.User;
import by.Matveev.service.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateUser implements UserDao {
    @Override
    public List<User> getUsers() {
        List<User> users = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            users = session.createQuery("FROM User", User.class).list();
        }catch (Exception e){
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
}
