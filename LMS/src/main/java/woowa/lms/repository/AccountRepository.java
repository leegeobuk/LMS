package woowa.lms.repository;

import woowa.lms.db.DB;
import woowa.lms.domain.account.Account;
import woowa.lms.domain.account.Owner;

import javax.persistence.EntityManager;
import java.util.List;

public class AccountRepository {

    private final EntityManager em = DB.getEntityManager();

    public void save(Account account) {
        em.persist(account);
    }

    public Account findById(String id) {
        return em.find(Account.class, id);
    }

    public List<Account> findByName(String name) {
        return em.createQuery("SELECT a FROM ACCOUNT a WHERE a.name = :name", Account.class)
            .setParameter(":name", name)
            .getResultList();
    }

    public List<Account> findAll() {
        return em.createQuery("SELECT a FROM ACCOUNT a", Account.class).getResultList();
    }
}
