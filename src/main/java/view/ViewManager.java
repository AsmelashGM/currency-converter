package view;

import controller.CurrencyController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import model.CurrencyDTO;

@Named(value = "viewManager")
@RequestScoped
public class ViewManager implements Serializable {
    @EJB
    private CurrencyController currencyController;
    private CurrencyDTO currency;
    private List<CurrencyBean> currencies;
    
    private double rate1;
    private double rate2;
    private double amount;
    private double result;
    
    private String code1;
    private String code2;
    
    public ViewManager(){ //Set default values
        rate1=0.118433;
        rate2=1.175685;
        amount=1.0;
        result=0.100735;
        code1="SEK";
        code2="EUR";
        setCurrencies();
    }

    public void setRate1(double rate1){ 
        this.rate1 = rate1; 
    }
    public double getRate1(){ 
        return this.rate1; 
    }
    
    public void setRate2(double rate2){ 
        this.rate2 = rate2; 
    }
    public double getRate2(){ 
        return this.rate2; 
    }
    
    public void setAmount(double amount){ 
        this.amount = amount; 
    }
    public double getAmount(){ 
        return this.amount; 
    }
    
    public void setCode1(String code1){ 
        this.code1 = code1; 
    }
    public String getCode1(){ 
        return this.code1; 
    }
    
    public void setCode2(String code2){ 
        this.code2 = code2; 
    }
    public String getCode2(){ 
        return this.code2; 
    }
    
    public double getResult(){ 
        return (double)Math.round(this.result*100d)/100d; 
    }
    public List<CurrencyBean> getCurrencies(){ 
        return this.currencies; 
    }
    public void setCurrencies(){
        currencies = new ArrayList<CurrencyBean>();
        currencies.add(new CurrencyBean("SEK", "Swedish krone"));
        currencies.add(new CurrencyBean("EUR", "Euro"));
        currencies.add(new CurrencyBean("USD", "US dollar"));
        currencies.add(new CurrencyBean("GBP", "British pound"));
        currencies.add(new CurrencyBean("DKK", "Danish krone"));
        currencies.add(new CurrencyBean("ETB", "Ethiopian birr"));
    }
    
    public void submit(){
        this.currency = currencyController.getCurrency(code1);
        this.rate1 = currency.getRate();
        this.currency = currencyController.getCurrency(code2);
        this.rate2 = currency.getRate();
 
        this.result = currencyController.getResult(rate1, rate2, amount); 
    }
}
