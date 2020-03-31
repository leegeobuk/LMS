package woowa.lms.back.repository.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.Customer;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerRepository implements AccountRepository<Customer> {

    private final EntityManager em;

    @Override
    public void save(Customer customer) {
        em.persist(customer);
    }

    @Override
    public Account findById(String id) {
        return em.createQuery("SELECT a FROM Account a WHERE TREAT(a as Customer).id = :id", Account.class)
            .setParameter("id", id)
            .getSingleResult();
    }

    @Override
    public List<Account> findByName(String name) {
        return em.createQuery("SELECT a FROM Account a WHERE TREAT(a as Customer).name = :name", Account.class)
            .setParameter("name", name)
            .getResultList();
    }

    @Override
    public List<Account> findAll() {
        return em.createQuery("SELECT a FROM ACCOUNT WHERE type(a) = Customer", Account.class)
            .getResultList();
    }
}
