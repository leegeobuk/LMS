package woowa.lms.repository;

import woowa.lms.domain.rental.Rental;

import javax.persistence.EntityManager;
import java.util.List;

public class RentalRepository {

    private final EntityManager em;

    public RentalRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Rental rental) {
        em.persist(rental);
    }

    public Rental findById(Long id) {
        return em.find(Rental.class, id);
    }

    public List<Rental> findAll() {
        return em.createQuery("SELECT r FROM RENTAL r", Rental.class).getResultList();
    }
}
