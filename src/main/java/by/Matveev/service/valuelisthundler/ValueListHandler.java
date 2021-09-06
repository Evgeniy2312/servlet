package by.Matveev.service.valuelisthundler;

import by.Matveev.entity.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ValueListHandler implements ValueListIterator<Operation>{
    private final List<Operation> operationList;

    public ValueListHandler(List<Operation> operationList) {
        this.operationList = operationList;
    }

    @Override
    public int getSize() {
        return operationList.size();
    }

    @Override
    public List<Operation> getCurrentElements(int currentPage, int numValues) {
        List<Operation> operations = new ArrayList<>();
        if (currentPage <=1){
            for(int i = 0; i < numValues; i++){
                if(i < operationList.size()){
                    operations.add(operationList.get(i));
                }
            }
        }else{
            int start = (currentPage - 1) * numValues;
            for (int i = start; i < start + numValues; i++){
                if(i < operationList.size()){
                    operations.add(operationList.get(i));
                }
            }
        }
        return operations;
    }

    @Override
    public List<Operation> getPreviouslyElements(int currentPage, int numValues) {
        List<Operation> operations = new ArrayList<>();
        if(currentPage <= 1){
            for (int i = 0; i < numValues - 1; i++){
                if(i < operationList.size()){
                    operations.add(operationList.get(i));
                }
            }
        }else {
            int end = (currentPage -1) * numValues;
            int start = end - numValues;
            if(start >= 0 && end > 0){
                operations = operationList.subList(start, end);
            }
        }
        return operations;
    }

    @Override
    public List<Operation> getNextElements(int currentPage, int numValues) {
        List<Operation> operations = new ArrayList<>();
        if(currentPage <= 1){
            int start = numValues;
            for (int i = start; i < numValues + start; i++){
                if(i <= operationList.size()){
                    operations.add(operationList.get(i));
                }
            }
        }else {
            int startNext = ((currentPage - 1) + numValues) + numValues;
            for (int i = startNext; startNext < startNext + numValues; i++){
                if (i < operationList.size()) {
                    operations.add(operationList.get(i));
                }
            }
        }
        return operations;
    }

}
