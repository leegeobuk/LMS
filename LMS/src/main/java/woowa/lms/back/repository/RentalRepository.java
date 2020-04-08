package woowa.lms.back.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.rental.Rental;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RentalRepository {

    private final EntityManager em;

    public void save(Rental rental) {
        em.persist(rental);
    }

    public void delete(Rental rental) {
        em.remove(rental);
    }

    public Rental findById(Long id) {
        return em.find(Rental.class, id);
    }

    public Rental findByAccount(String accountId) {
        String query = "SELECT r FROM Rental r WHERE r.account.id = :accountId";
        return em.createQuery(query, Rental.class)
            .setParameter("accountId", accountId)
            .getSingleResult();
    }

    public List<Account> findByItem(Long itemId) {
        String query = "SELECT a FROM Account a " +
            "JOIN a.rentals r JOIN r.rentalItems i WHERE i.item.id = :itemId";
        return em.createQuery(query, Account.class)
            .setParameter("itemId", itemId)
            .getResultList();
    }

    public List<Rental> findAll() {
        return em.createQuery("SELECT r FROM Rental r", Rental.class)
            .getResultList();
    }
}
