package woowa.lms.domain;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import woowa.lms.db.DB;
import woowa.lms.domain.account.Account;
import woowa.lms.domain.account.Owner;
import woowa.lms.domain.item.Book;
import woowa.lms.domain.item.Item;
import woowa.lms.domain.rental.Rental;
import woowa.lms.domain.rental.RentalItem;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RentalItemTest {
    static EntityManager em = DB.getEntityManager();
    static final String OWNER = "LeeDM";
    static final String CO_OWNER = "YoonKH";
    static final String HAMLET = "Hamlet";
    static final String OTHELLO = "Othello";
    static final String SHAKESPEARE = "Shakespeare";
    static final String PW = "password";

    static Account dm;
    static Account kh;
    static Item hamlet;
    static Item othello;
    static RentalItem dmHamlet;
    static RentalItem dmOthello;
    static RentalItem khOthello;
    static Rental dmRental;
    static Rental khRental;

    @BeforeAll
    static void beforeAll() {
        dm = Owner.of(OWNER, PW);
        dm.setName(OWNER.substring(OWNER.length() - 2));
        dm.setContact("01096990080");
        kh = Owner.of(CO_OWNER, PW);
        kh.setName(CO_OWNER.substring(CO_OWNER.length() - 2));
        kh.setContact("01012345677");

        hamlet = Book.of(HAMLET, SHAKESPEARE, 5);
        othello = Book.of(OTHELLO, SHAKESPEARE, 5);

        dmHamlet = RentalItem.createRentalItem(hamlet, 3);
        dmOthello = RentalItem.createRentalItem(othello, 2);
        khOthello = RentalItem.createRentalItem(othello, 1);

        dmRental = Rental.createRental(dm, dmHamlet, dmOthello);
        khRental = Rental.createRental(kh, khOthello);

        em.persist(dm);
        em.persist(kh);
        em.persist(hamlet);
        em.persist(othello);
        em.persist(dmHamlet);
        em.persist(dmOthello);
        em.persist(khOthello);
        em.persist(dmRental);
        em.persist(khRental);
    }

    @Test
    public void testAccountItemRelation() {
        Account owner = em.find(Owner.class, OWNER);
        Account coOwner = em.find(Owner.class, CO_OWNER);

        assertEquals(owner.getRentals().get(0).getRentalItems().get(0), dmHamlet, "Wrong dm hamlet");
        assertEquals(owner.getRentals().get(0).getRentalItems().get(1), dmOthello, "Wrong dm othello");
        assertEquals(coOwner.getRentals().get(0).getRentalItems().get(0), khOthello, "Wrong kh othello");
    }

    @AfterAll
    static void afterAll() {
        em.remove(dm);
        em.remove(kh);
        em.remove(hamlet);
        em.remove(othello);
        em.remove(dmHamlet);
        em.remove(dmOthello);
        em.remove(khOthello);
        em.remove(dmRental);
        em.remove(khRental);

        em.close();
    }
}