package woowa.lms.back.repository.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.Admin;
import woowa.lms.back.domain.account.User;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional(readOnly = true)
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
        return em.createQuery("SELECT a FROM Account a WHERE a.name = :name", Account.class)
            .setParameter("name", name)
            .getResultList();
    }

    public List<Account> findAdmins() {
        return em.createQuery("SELECT a FROM Account a WHERE type(a) = Admin", Account.class)
            .getResultList();
    }

    public List<Account> findUsers() {
        return em.createQuery("SELECT a FROM Account a WHERE type(a) = User", Account.class)
            .getResultList();
    }

    public List<Account> findAll() {
        return em.createQuery("SELECT a FROM Account a", Account.class)
            .getResultList();
    }
}
