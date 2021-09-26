package by.Matveev.service;

import by.Matveev.dao.AddressDao;
import by.Matveev.dao.HibernateAddress;
import by.Matveev.dao.ListAddress;
import by.Matveev.dao.MySqlAddressImpl;
import by.Matveev.entity.Address;

import java.util.List;

public class AddressService {

    private AddressDao addressDao;

    public AddressService(HibernateAddress hibernateAddress){
        this.addressDao = hibernateAddress;
    }

    public List<Address> getAll(){
        return addressDao.getAddresses();
    }

    public boolean addAddress(Address address){
        if(!addressDao.check(address) && address.getUser() != null ){
            addressDao.addAddress(address);
            return true;
        }else return false;
    }

    public boolean updateAddress(Address address, int num, String street){
        if(addressDao.isExist(address) && address.getUser() != null ){
            addressDao.updateAddress(address, street, num);
            return true;
        }else return false;
    }

    public boolean deleteAddress(Address address){
        Address address1 = addressDao.getById(address);
        if (addressDao.isExist(address1) && address1.getUser() != null
        && !address1.isPrimary()){
            addressDao.deleteAddress(address);
            return true;
        }else return false;
    }

}
