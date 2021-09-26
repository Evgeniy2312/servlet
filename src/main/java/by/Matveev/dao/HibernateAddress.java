package by.Matveev.dao;

import by.Matveev.entity.Address;
import by.Matveev.service.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class HibernateAddress implements AddressDao {


    @Override
    public void addAddress(Address address) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(address);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAddress(Address address) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(address);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void updateAddress(Address address, String street, int num) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Address address1 = session.get(Address.class, address.getId());
            address1.setStreet(street);
            address1.setNumber(num);
            session.update(address1);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Address> getAddresses() {
        List<Address> addresses = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            addresses = session.createQuery("From Address ", Address.class).getResultList();
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return addresses;
    }

    @Override
    public boolean isExist(Address address) {
        Transaction transaction = null;
        boolean flag = false;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Optional<Address> addressOptional = getAddress(address, session);
            if(addressOptional.isPresent()){
                if (address.equals(addressOptional.get())) {
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
        return flag;
    }

    @Override
    public boolean check(Address address) {
        Transaction transaction = null;
        boolean flag = false;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Optional<Address> addressOptional = getAddress(address, session);
            if(addressOptional.isPresent()){
                Address address1 = addressOptional.get();
                if (address.getNumber() == address1.getNumber() && address.getStreet().equals(address1.getStreet())
                && address.getUser().getId() == address1.getUser().getId()) {
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
        return flag;
    }

    private Optional<Address> getAddress(Address address, Session session) {
        return session.createQuery("from Address where id = : id and " +
                " user.id = : user_id", Address.class).setParameter("id", address.getId())
                .setParameter("user_id", address.getUser().getId())
                .uniqueResultOptional();
    }

    @Override
    public Address getById(Address address) {
        Address address1 = new Address();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            address1 = session.createQuery("From Address WHERE id = : id", Address.class)
                    .setParameter("id", address.getId())
                    .getSingleResult();
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return address1;
    }
}
