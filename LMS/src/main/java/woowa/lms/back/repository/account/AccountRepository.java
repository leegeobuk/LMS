package woowa.lms.back.repository.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.AccountSearchCriteria;
import woowa.lms.back.domain.account.Admin;
import woowa.lms.back.domain.account.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountRepository {

    private final EntityManager em;

    public void save(Account account) {
        em.persist(account);
    }

    public void delete(Account account) {
        em.remove(account);
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

    public List<Account> findAll(AccountSearchCriteria criteria) {
        String jpql = "SELECT a FROM Account a";
        boolean prevCondition = false;
        if (StringUtils.hasText(criteria.getId())) {
            prevCondition = true;
            jpql += " WHERE a.id LIKE :id";
        }
        if (StringUtils.hasText(criteria.getName())) {
            jpql += prevCondition ? " AND" : " WHERE";
            jpql += " a.name LIKE :name";
            prevCondition = true;
        }
        if (StringUtils.hasText(criteria.getContact())) {
            jpql += prevCondition ? " AND" : " WHERE";
            jpql += " a.contact LIKE :contact";
        }

        TypedQuery<Account> query = em.createQuery(jpql, Account.class);
        if (jpql.contains(":id")) {
            query.setParameter("id", criteria.getId());
        }
        if (jpql.contains(":name")) {
            query.setParameter("name", criteria.getName());
        }
        if (jpql.contains(":contact")) {
            query.setParameter("contact", criteria.getContact());
        }
        return query.getResultList();
    }

    public List<Account> findAll() {
        return em.createQuery("SELECT a FROM Account a", Account.class)
            .getResultList();
    }
}
