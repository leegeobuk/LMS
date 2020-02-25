package woowa.lms.domain;

import org.junit.jupiter.api.*;
import woowa.lms.db.DB;
import woowa.lms.domain.account.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnerLibraryTest {

    static EntityManager em = DB.getEntityManager();
    static EntityTransaction tx;
    static final String OWNER = "LeeDM";
    static final String CO_OWNER = "YoonKH";
    static final String BAEMIN = "Baemin";
    static final String SEONGSIN = "Seongsin";
    static final String PW = "password";
    static Owner dm;
    static Owner kh;
    static OwnerLibrary dmBaemin;
    static OwnerLibrary dmSeongsin;
    static OwnerLibrary khSeongsin;
    static Library baemin;
    static Library seongsin;

    @BeforeAll
    static void setUp() {
        tx = em.getTransaction();
        tx.begin();

        dm = Owner.of(OWNER);
//        dm = em.find(Owner.class, OWNER);
        dm.setPw(PW);
        dm.setName(OWNER.substring(OWNER.length() - 2));
        dm.setContact("01096990080");
        kh = Owner.of(CO_OWNER);
//        kh = em.find(Owner.class, CO_OWNER);
        kh.setPw(PW);
        kh.setName(CO_OWNER.substring(CO_OWNER.length() - 2));
        kh.setContact("01012345677");

        baemin = new Library();
        baemin.setName(BAEMIN);
        seongsin = new Library();
        seongsin.setName(SEONGSIN);

        dmBaemin = new OwnerLibrary();
        dmBaemin.setOwner(dm);
        dmBaemin.setLibrary(baemin);
        dmSeongsin = new OwnerLibrary();
        dmSeongsin.setOwner(dm);
        dmSeongsin.setLibrary(seongsin);
        khSeongsin = new OwnerLibrary();
        khSeongsin.setOwner(kh);
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

        assertEquals(owner.getOwnerLibraries().get(0).getLibrary(), baemin, "Wrong dm baemin");
        assertEquals(owner.getOwnerLibraries().get(1).getLibrary(), seongsin, "Wrong dm seongsin");
        assertEquals(coOwner.getOwnerLibraries().get(0).getLibrary(), seongsin, "Wrong kh seongsin");

        assertEquals(library1.getOwnerLibraries().get(0).getOwner(), owner, "Wrong baemin dm");
        assertEquals(library2.getOwnerLibraries().get(0).getOwner(), owner, "Wrong seongsi dm");
        assertEquals(library2.getOwnerLibraries().get(1).getOwner(), coOwner, "Wrong seongsi kh");
    }

    @AfterAll
    static void tearDown() {
        em.close();
    }
}
