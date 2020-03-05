package woowa.lms.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import woowa.lms.domain.rental.Rental;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RentalRepository {

    private final EntityManager em;

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
