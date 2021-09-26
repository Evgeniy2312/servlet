package by.Matveev.service;


import by.Matveev.dao.HibernateUser;
import by.Matveev.dao.MySqlUserImpl;
import by.Matveev.entity.Address;
import by.Matveev.entity.Operation;
import by.Matveev.entity.Telephone;
import by.Matveev.entity.User;


import java.util.List;
import java.util.Optional;

public class ServiceFacade {

    public double calculate(Operation operation){
        double result = Dependencies.calculateService.getDouble(operation);
        Dependencies.recordingHistoryService.record(operation);
        return result;
    }

    public Optional<User> authorization(User user){
        return Dependencies.authorizationService.logIn(user);
    }

    public boolean registration(User  user) {
        return Dependencies.registrationService.addUser(user);
    }

    public boolean changePassword(User user, String password){
        return Dependencies.changePasswordService.changePassword(user, password);
    }

    public List<Operation> getOperationBySession(User user, int currentPage, int numValues ){
        return Dependencies.historyService2.listOperationBySession(currentPage, numValues, user);
    }

    public List<Operation> getOperationByType(int currentPage, int numValues, User user, String type){
        return  Dependencies.historyService2.listOperationByType(currentPage, numValues, user, type);
    }

    public List<Address> getAddresses(){
        return Dependencies.addressService.getAll();
    }

    public List<Telephone> getTelephones(){
        return Dependencies.telephoneService.getAll();
    }

    public boolean addAddress(Address address){
        return Dependencies.addressService.addAddress(address);
    }

    public boolean addTelephone(Telephone telephone){
        return Dependencies.telephoneService.addTelephone(telephone);
    }

    public boolean updateTelephone(Telephone telephone, long num){
        return Dependencies.telephoneService.updateTelephone(telephone, num);
    }

    public boolean updateAddress(Address address, int num, String street){
        return Dependencies.addressService.updateAddress(address, num, street);
    }

    public boolean deleteAddress(Address address){
        return Dependencies.addressService.deleteAddress(address);
    }

    public boolean deleteTelephone(Telephone telephone){
        return Dependencies.telephoneService.deleteTelephone(telephone);
    }

    public User getByLogin(String login){
        return new HibernateUser().getUserByLogin(login);
    }


}
