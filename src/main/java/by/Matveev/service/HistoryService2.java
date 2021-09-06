package by.Matveev.service;

import by.Matveev.dao.HibernateOperations;
import by.Matveev.dao.ListOperations;
import by.Matveev.dao.RememberingInformationDao;
import by.Matveev.entity.Operation;
import by.Matveev.entity.User;
import by.Matveev.service.valuelisthundler.ValueListHandler;
import by.Matveev.service.valuelisthundler.ValueListIterator;
import java.util.List;


public class HistoryService2 {
    private RememberingInformationDao rememberingInformationDao;
    private int sizeListForResp;
    public HistoryService2(HibernateOperations hibernateOperations){
        this.rememberingInformationDao = hibernateOperations;
    }

    public List<Operation> listOperationBySession(int currentPage, int numValues, User user){
        ValueListIterator<Operation> operationValueListIterator = new ValueListHandler(rememberingInformationDao.getOperationBySession(user));
        List<Operation> operations = operationValueListIterator.getCurrentElements(currentPage, numValues);
        sizeListForResp = setNumPage(operationValueListIterator.getSize(), numValues);
        return  operations;
    }

    public List<Operation> listOperationByType(int currentPage, int numValues, User user, String type){
        ValueListIterator<Operation> operationValueListIterator = new ValueListHandler(rememberingInformationDao.getOperationByNameOfFunctions(user, type));
        List<Operation> operations = operationValueListIterator.getCurrentElements(currentPage, numValues);
        sizeListForResp = setNumPage(operationValueListIterator.getSize(), numValues);
        return  operations;
    }

    public int getSizeListForResp() {
        return sizeListForResp;
    }

    private int setNumPage(int sizeList, int numValuesPage){
        if(sizeList % numValuesPage == 0){
            return sizeList /  numValuesPage;
        }else return sizeList / numValuesPage + 1;
    }
}
