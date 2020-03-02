package woowa.lms.domain;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import woowa.lms.db.DB;
import woowa.lms.domain.account.Account;
import woowa.lms.domain.account.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountLibraryTest {

    static EntityManager em = DB.getEntityManager();
    static EntityTransaction tx;
    static final String OWNER = "Lee.DM";
    static final String CO_OWNER = "Yoon.KH";
    static final String BAEMIN = "Baemin";
    static final String SEONGSIN = "Seongsin";
    static final String PW = "password";

    static Owner dm;
    static Owner kh;
    static AccountLibrary dmBaemin;
    static AccountLibrary dmSeongsin;
    static AccountLibrary khSeongsin;
    static Library baemin;
    static Library seongsin;

    @BeforeAll
    static void beforeAll() {
        dm = Owner.of(OWNER, PW);
        dm.setName(OWNER.substring(OWNER.length() - 2));
        dm.setContact("01096990080");
        kh = Owner.of(CO_OWNER, PW);
        kh.setName(CO_OWNER.substring(CO_OWNER.length() - 2));
        kh.setContact("01012345677");

        baemin = new Library();
        baemin.setName(BAEMIN);
        seongsin = new Library();
        seongsin.setName(SEONGSIN);

        dmBaemin = AccountLibrary.of(dm, baemin);
        dmSeongsin = AccountLibrary.of(dm, seongsin);
        khSeongsin = AccountLibrary.of(kh, seongsin);

        em.persist(dm);
        em.persist(kh);
        em.persist(baemin);
        em.persist(seongsin);
        em.persist(dmBaemin);
        em.persist(dmSeongsin);
        em.persist(khSeongsin);
    }

    @Test
    public void testAccountLibraryRelation() {
        Account owner = em.find(Owner.class, OWNER);
        Account coOwner = em.find(Owner.class, CO_OWNER);

        Library library1 = em.find(Library.class, baemin.getId());
        Library library2 = em.find(Library.class, seongsin.getId());

        assertEquals(owner.getAccountLibraries().get(0).getLibrary(), baemin, "Wrong dm baemin");
        assertEquals(owner.getAccountLibraries().get(1).getLibrary(), seongsin, "Wrong dm seongsin");
        assertEquals(coOwner.getAccountLibraries().get(0).getLibrary(), seongsin, "Wrong kh seongsin");

        assertEquals(library1.getAccountLibraries().get(0).getAccount(), owner, "Wrong baemin dm");
        assertEquals(library2.getAccountLibraries().get(0).getAccount(), owner, "Wrong seongsi dm");
        assertEquals(library2.getAccountLibraries().get(1).getAccount(), coOwner, "Wrong seongsi kh");
    }

    @AfterAll
    static void afterAll() {
        em.remove(dm);
        em.remove(kh);
        em.remove(baemin);
        em.remove(seongsin);
        em.remove(dmBaemin);
        em.remove(dmSeongsin);
        em.remove(khSeongsin);

        em.close();
    }
}
