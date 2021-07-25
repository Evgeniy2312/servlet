package by.Mayveev.dao;

import java.util.List;

public interface RememberingInformationDao {
    List<String> getStore();
    List<String> getResults(int i, int i2, String calculation, String result);
}
