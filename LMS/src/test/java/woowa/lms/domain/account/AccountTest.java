package woowa.lms.domain.account;

import org.junit.jupiter.api.Test;
import woowa.lms.db.DB;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    EntityManager em = DB.getEntityManager();

    @Test
    public void testGetName() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Account owner = new Owner("leegeobuk", "freestyle2011", "DM", "01096990080");
        em.persist(owner);
        em.flush();
        Account account = em.find(Owner.class, "leegeobuk");
        tx.commit();
        assertEquals(owner.getName(), account.getName(), "Wrong owner name");
    }

}