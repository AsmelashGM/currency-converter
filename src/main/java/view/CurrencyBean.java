package view;
public class CurrencyBean {
    String code;
    String name;
    
    public CurrencyBean(String code, String name) {
        this.code = code;
        this.name = name;
    }
    public String getCode(){
        return this.code;
    }
    public String getName(){
        return this.name;
    }
}
