package by.Matveev.service;


import by.Matveev.dao.HibernateTelephone;
import by.Matveev.dao.MySqlTelephoneImpl;
import by.Matveev.dao.TelephoneDao;
import by.Matveev.entity.Telephone;

import java.util.List;

public class TelephoneService {
    private TelephoneDao telephoneDao;

    public TelephoneService(HibernateTelephone hibernateTelephone){
        this.telephoneDao = hibernateTelephone;
    }

    public List<Telephone> getAll(){
        return telephoneDao.getTelephones();
    }

    public boolean addTelephone(Telephone telephone){
        if(!telephoneDao.check(telephone) && telephone.getUser() != null){
            telephoneDao.addTelephone(telephone);
            return true;
        }else return false;
    }

    public boolean updateTelephone(Telephone telephone, long num){
        if(telephoneDao.isExist(telephone)&& telephone.getUser() != null){
            telephoneDao.updateTelephone(telephone, num);
            return true;
        }else return false;
    }

    public boolean deleteTelephone(Telephone telephone){
        Telephone telephone1 = telephoneDao.getById(telephone);
        if(telephoneDao.isExist(telephone1) && telephone1.getUser() != null
                && !telephone1.isPrimary()){
            telephoneDao.deleteTelephone(telephone);
            return true;
        }else return false;
    }



}
