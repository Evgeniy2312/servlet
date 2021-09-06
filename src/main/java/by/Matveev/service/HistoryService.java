package by.Matveev.service;

import by.Matveev.dao.HibernateOperations;
import by.Matveev.dao.ListOperations;
import by.Matveev.dao.MySqlOperationsDao;
import by.Matveev.dao.RememberingInformationDao;
import by.Matveev.entity.Operation;
import by.Matveev.entity.User;

import java.util.List;

public class HistoryService {
    private RememberingInformationDao informationDao;
    public HistoryService(HibernateOperations hibernateOperations){
        this.informationDao = hibernateOperations;
    }

    public List<Operation> getOperationBySession(User user){
        return informationDao.getOperationBySession(user);
    }

    public List<Operation> getOperationByType(User user, String type){
        return informationDao.getOperationByNameOfFunctions(user, type);
    }
}
