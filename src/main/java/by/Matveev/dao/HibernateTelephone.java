package by.Matveev.dao;


import by.Matveev.entity.Address;
import by.Matveev.entity.Telephone;
import by.Matveev.service.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class HibernateTelephone implements TelephoneDao {
    @Override
    public void addTelephone(Telephone telephone) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(telephone);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTelephone(Telephone telephone) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(telephone);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void updateTelephone(Telephone telephone, long num) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Telephone telephone1 = session.get(Telephone.class, telephone.getId());
            telephone1.setNumber(num);
            session.update(telephone1);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Telephone> getTelephones() {
        List<Telephone> telephones = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            telephones = session.createQuery("From Telephone ", Telephone.class).getResultList();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return telephones;
    }

    @Override
    public boolean isExist(Telephone telephone) {
        Transaction transaction = null;
        boolean flag = false;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Optional<Telephone> telephoneOptional = getTelephone(telephone, session);
            if(telephoneOptional.isPresent()){
                if(telephone.equals(telephoneOptional.get())) {
                    flag = true;
                }
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return flag
                ;
    }

    private Optional<Telephone> getTelephone(Telephone telephone, Session session) {
        return session.createQuery("from Telephone where id = : id and user.id = : user_id", Telephone.class)
                .setParameter("id", telephone.getId())
                .setParameter("user_id", telephone.getUser().getId())
                .uniqueResultOptional();
    }

    @Override
    public boolean check(Telephone telephone) {
        Transaction transaction = null;
        boolean flag = false;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Optional<Telephone> telephoneOptional = getTelephone(telephone, session);
            if(telephoneOptional.isPresent()){
                Telephone telephone1 = telephoneOptional.get();
                if(telephone.getNumber() == telephone1.getNumber() &&
                        telephone1.getUser().getId() == telephone.getUser().getId()) {
                    flag = true;
                }
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return flag
                ;
    }

    @Override
    public Telephone getById(Telephone telephone) {
        Telephone telephone1 = new Telephone();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            telephone1 = session.createQuery("From Telephone WHERE id = : id", Telephone.class)
                    .setParameter("id", telephone.getId())
                    .getSingleResult();
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return telephone1;
    }
}

