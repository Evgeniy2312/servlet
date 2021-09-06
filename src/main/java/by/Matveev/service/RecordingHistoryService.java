package by.Matveev.service;

import by.Matveev.dao.HibernateOperations;
import by.Matveev.dao.ListOperations;
import by.Matveev.dao.MySqlOperationsDao;
import by.Matveev.dao.RememberingInformationDao;
import by.Matveev.entity.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecordingHistoryService {
    private RememberingInformationDao informationDao;
    private static final Logger logger = LoggerFactory.getLogger(RecordingHistoryService.class);

    public RecordingHistoryService(HibernateOperations hibernateOperations) {
        this.informationDao = hibernateOperations;
    }

    public void record(Operation operation){
        informationDao.addOperation(operation);
        logger.info("Operation with number - {}, {}, with type of operation - " +
                        "{}, with result - {} and accomplished by User {} recorded in the history.", operation.getI1(), operation.getI2(),
        operation.getOperation(), operation.getResult(),  operation.getUser().getName());
    }
}
