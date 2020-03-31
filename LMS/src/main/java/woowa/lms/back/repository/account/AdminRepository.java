package woowa.lms.back.repository.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.Admin;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminRepository implements AccountRepository<Admin> {

    private final EntityManager em;

    public void save(Admin admin) {
        em.persist(admin);
    }

    public Account findById(String id) {
        return em.createQuery("SELECT a FROM Account a WHERE treat(a as Admin).id = :id", Account.class)
            .setParameter("id", id)
            .getSingleResult();
    }

    public List<Account> findByName(String name) {
        return em.createQuery("SELECT a FROM Account a WHERE TREAT(a as Admin).name = :name", Account.class)
            .setParameter("name", name)
            .getResultList();
    }

    public List<Account> findAll() {
        return em.createQuery("SELECT a FROM ACCOUNT WHERE type(a) = Admin", Account.class)
            .getResultList();
    }
}
