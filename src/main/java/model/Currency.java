package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency implements CurrencyDTO, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String code;
    private double rate;
    private String name;
    
    public Currency(){}
    public Currency(String code, String name){
        this.code = code;
        this.name = name;
    }
    
    @Override
    public double getRate() {
        return this.rate;
    }

    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public String getCode() {
        return this.code;
    }
}
