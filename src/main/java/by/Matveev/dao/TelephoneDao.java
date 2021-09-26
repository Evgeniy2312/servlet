package by.Matveev.dao;

import by.Matveev.entity.Address;
import by.Matveev.entity.Telephone;
import by.Matveev.entity.User;

import java.util.List;

public interface TelephoneDao {
    void addTelephone(Telephone telephone);
    void deleteTelephone(Telephone telephone);
    void updateTelephone(Telephone telephone, long num);
    List<Telephone> getTelephones();
    boolean isExist(Telephone telephone);
    boolean check(Telephone telephone);
    Telephone getById(Telephone telephone);
}
