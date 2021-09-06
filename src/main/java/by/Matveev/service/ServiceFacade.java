package by.Matveev.service;


import by.Matveev.entity.Operation;
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

    public boolean registration(User  user){
        return Dependencies.registrationService.addUser(user);
    }

    public void changePassword(User user, String password){
        Dependencies.changePasswordService.changePassword(user, password);
    }


    public List<Operation> getOperationBySession(User user, int currentPage, int numValues ){
        return Dependencies.historyService2.listOperationBySession(currentPage, numValues, user);
    }

    public List<Operation> getOperationByType(int currentPage, int numValues, User user, String type){
        return  Dependencies.historyService2.listOperationByType(currentPage, numValues, user, type);
    }

}
