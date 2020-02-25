package woowa.lms.domain;

import org.junit.jupiter.api.*;
import woowa.lms.db.DB;
import woowa.lms.domain.account.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountLibraryTest {

    static EntityManager em = DB.getEntityManager();
    static EntityTransaction tx;
    static final String OWNER = "LeeDM";
    static final String CO_OWNER = "YoonKH";
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
    static void setUp() {
        tx = em.getTransaction();
        tx.begin();

        dm = Owner.of(OWNER);
        dm.setPw(PW);
        dm.setName(OWNER.substring(OWNER.length() - 2));
        dm.setContact("01096990080");
        kh = Owner.of(CO_OWNER);
        kh.setPw(PW);
        kh.setName(CO_OWNER.substring(CO_OWNER.length() - 2));
        kh.setContact("01012345677");

        baemin = new Library();
        baemin.setName(BAEMIN);
        seongsin = new Library();
        seongsin.setName(SEONGSIN);

        dmBaemin = new AccountLibrary();
        dmBaemin.setAccount(dm);
        dmBaemin.setLibrary(baemin);
        dmSeongsin = new AccountLibrary();
        dmSeongsin.setAccount(dm);
        dmSeongsin.setLibrary(seongsin);
        khSeongsin = new AccountLibrary();
        khSeongsin.setAccount(kh);
        khSeongsin.setLibrary(seongsin);

        em.persist(dm);
        em.persist(kh);
        em.persist(baemin);
        em.persist(seongsin);
        em.persist(dmBaemin);
        em.persist(dmSeongsin);
        em.persist(khSeongsin);

        tx.commit();
        em.clear();
    }

    @BeforeEach
    public void startTransaction() {
        tx = em.getTransaction();
        tx.begin();
    }

    @AfterEach
    public void commitTransaction() {
        tx.commit();
    }

    @Test
    public void testOwnerLibraryRelation() {
        Owner owner = em.find(Owner.class, OWNER);
        Owner coOwner = em.find(Owner.class, CO_OWNER);

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
    static void tearDown() {
        em.close();
    }
}
