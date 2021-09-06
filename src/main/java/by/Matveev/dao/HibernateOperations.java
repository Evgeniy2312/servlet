package by.Matveev.dao;

import by.Matveev.entity.Operation;
import by.Matveev.entity.User;
import by.Matveev.service.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;



import java.util.List;

public class HibernateOperations implements RememberingInformationDao {
    @Override
    public void addOperation(Operation operation) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(operation);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public List<Operation> getOperations() {
        List<Operation> operations = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            operations = session.createQuery("From Operation", Operation.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return operations;
    }

    @Override
    public List<Operation> getOperationBySession(User user) {
        List<Operation> operations = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            operations = session.createQuery("FROM Operation  WHERE user =: user", Operation.class )
                    .setParameter("user", user)
                    .list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return operations;
    }

    @Override
    public List<Operation> getOperationByNameOfFunctions(User user, String name) {
        List<Operation> operations = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            operations = session.createQuery("FROM Operation  WHERE user =: user AND typeOfOperation =: type ", Operation.class )
                    .setParameter("user", user)
                    .setParameter("type", name)
                    .list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return operations;
    }
}
