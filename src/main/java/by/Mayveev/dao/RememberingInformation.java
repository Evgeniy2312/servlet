package by.Mayveev.dao;

import java.util.ArrayList;
import java.util.List;

public class RememberingInformation implements RememberingInformationDao {
    private static List<String> store = new ArrayList<>();

    public  List<String> getStore(){
        return store;
    }

    @Override
    public List<String> getResults(int i, int i2, String calculation, String result) {
        String result1 = "Function - " + calculation + "; with number - " + i +  " , " + i2 + "; result - " + result ;
        getStore().add(result1);
        return getStore();
    }
}
