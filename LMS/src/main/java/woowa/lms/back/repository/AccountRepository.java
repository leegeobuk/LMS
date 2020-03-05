package woowa.lms.back.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import woowa.lms.back.domain.account.Account;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccountRepository {

    private final EntityManager em;

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
