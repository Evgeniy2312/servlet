package by.Matveev.dao;

import by.Matveev.entity.Telephone;

import java.util.ArrayList;
import java.util.List;

public class ListTelephone implements TelephoneDao{
    private static final List<Telephone> telephones = new ArrayList<>();

    @Override
    public void addTelephone(Telephone telephone) {
        telephones.add(new Telephone(telephones.size() + 1,telephone.getNumber(), telephone.getUser(), telephone.isPrimary()));
    }

    @Override
    public void deleteTelephone(Telephone telephone) {
        telephones.remove(telephone);
    }

    @Override
    public void updateTelephone(Telephone telephone, long num) {
        Telephone telephone1 = telephones.get(telephones.indexOf(telephone));
        telephone1.setNumber(num);
    }

    @Override
    public List<Telephone> getTelephones() {
        return telephones;
    }

    @Override
    public boolean isExist(Telephone telephone) {
        return telephones.contains(telephone);
    }

    @Override
    public boolean check(Telephone telephone){
        for (Telephone telephone1: telephones){
            if(telephone.getNumber() == telephone1.getNumber()
                    && telephone.getUser().getId() == telephone1.getUser().getId()){
                return true;
            }
        }
        return false;
    }

    @Override
    public Telephone getById(Telephone telephone) {
        return telephones.get(telephones.indexOf(telephone));
    }
}
