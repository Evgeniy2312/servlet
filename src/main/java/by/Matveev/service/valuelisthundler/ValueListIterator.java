package by.Matveev.service.valuelisthundler;

import by.Matveev.entity.Operation;

import java.util.List;

public interface ValueListIterator<T> {
    int getSize();
    List<T> getCurrentElements(int currentPage, int numValues);
    List<T> getPreviouslyElements(int currentPage, int numValues);
    List<T> getNextElements(int currentPage, int numValues);
}
