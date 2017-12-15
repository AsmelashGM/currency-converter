package integration;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import model.Currency;

@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
public class CurrencyDAO {
    @PersistenceContext(unitName = "CurrencyConverterPU")
    private EntityManager em;

    public Currency findCurrency(String code) {
        Currency currency = em.find(Currency.class, code);
        if (currency == null) {
            throw new EntityNotFoundException("No currency with code = " + code);
        }
        return currency;
    }
}