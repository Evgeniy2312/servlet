package by.Matveev.dao;

import by.Matveev.entity.Address;

import java.util.ArrayList;
import java.util.List;

public class ListAddress implements AddressDao{
    private static final List<Address> addresses = new ArrayList<>();

    @Override
    public void addAddress(Address address) {
        addresses.add(new Address(addresses.size() + 1, address.getNumber(), address.getStreet(), address.getUser(), address.isPrimary()));
    }

    @Override
    public void deleteAddress(Address address) {
        addresses.remove(address);
    }

    @Override
    public void updateAddress(Address address, String street, int num) {
        Address address1 = addresses.get(addresses.indexOf(address));
        address1.setNumber(num);
        address1.setStreet(street);
    }

    @Override
    public List<Address> getAddresses() {
        return addresses;
    }

    @Override
    public boolean isExist(Address address) {
        return addresses.contains(address);
    }

    public boolean check(Address address){
        for(Address address1: getAddresses()){
            if(address.getStreet().equals(address1.getStreet()) && address.getNumber() == address1.getNumber()
            && address.getUser().getId() == address1.getUser().getId()){
                return true;
            }
        }
        return false;
    }

    @Override
    public Address getById(Address address) {
        return addresses.get(addresses.indexOf(address));
    }
}
