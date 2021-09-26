package by.Matveev.dao;

import by.Matveev.entity.Address;


import java.util.List;

public interface AddressDao {

    void addAddress(Address address);
    void deleteAddress(Address address);
    void updateAddress(Address address, String street, int num);
    List<Address> getAddresses();
    boolean isExist(Address address);
    boolean check(Address address);
    Address getById(Address address);
}
