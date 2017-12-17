package controller;

import integration.CurrencyDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import model.CurrencyDTO;

@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class CurrencyController {
    @EJB CurrencyDAO currencyDB;
    public double getResult(double rate1, double rate2, double amount){
        double result = (rate1/rate2)*amount;
        return result;
    }
    
    public CurrencyDTO getCurrency(String code) {
        return currencyDB.findCurrency(code);
    }
}
