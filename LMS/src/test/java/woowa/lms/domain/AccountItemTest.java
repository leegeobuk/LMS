package woowa.lms.domain;

import org.junit.jupiter.api.*;
import woowa.lms.db.DB;
import woowa.lms.domain.account.Owner;
import woowa.lms.domain.item.Book;
import woowa.lms.domain.item.Item;
import woowa.lms.domain.item.ItemStatus;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class AccountItemTest {
    static EntityManager em = DB.getEntityManager();
    static EntityTransaction tx;
    static final String OWNER = "LeeDM";
    static final String CO_OWNER = "YoonKH";
    static final String HAMLET = "Hamlet";
    static final String OTHELLO = "Othello";
    static final String SHAKESPEARE = "Shakespeare";
    static final String PW = "password";
    static Owner dm;
    static Owner kh;
    static AccountItem dmHamlet;
    static AccountItem dmOthello;
    static AccountItem khOthello;
    static Item hamlet;
    static Item othello;

    @BeforeAll
    static void beforeAll() {
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

        hamlet = new Book();
        hamlet.setTitle(HAMLET);
        hamlet.setAuthor(SHAKESPEARE);
        hamlet.setStatus(ItemStatus.IN);
        othello = new Book();
        othello.setTitle(OTHELLO);
        othello.setAuthor(SHAKESPEARE);
        othello.setStatus(ItemStatus.IN);

        dmHamlet = new AccountItem();
        dmHamlet.setAccount(dm);
        dmHamlet.setItem(hamlet);
        dmOthello = new AccountItem();
        dmOthello.setAccount(dm);
        dmOthello.setItem(othello);
        khOthello = new AccountItem();
        khOthello.setAccount(kh);
        khOthello.setItem(othello);

        em.persist(dm);
        em.persist(kh);
        em.persist(hamlet);
        em.persist(othello);
        em.persist(dmHamlet);
        em.persist(dmOthello);
        em.persist(khOthello);

        tx.commit();
        em.clear();
    }

    @BeforeEach
    public void setUp() {
        tx = em.getTransaction();
        tx.begin();
    }

    @Test
    public void testAccountItemRelation() {
        Owner owner = em.find(Owner.class, OWNER);
        Owner coOwner = em.find(Owner.class, CO_OWNER);

        Item item1 = em.find(Item.class, hamlet.getId());
        Item item2 = em.find(Item.class, othello.getId());

        assertEquals(owner.getAccountItems().get(0).getItem(), hamlet, "Wrong dm hamlet");
        assertEquals(owner.getAccountItems().get(1).getItem(), othello, "Wrong dm othello");
        assertEquals(coOwner.getAccountItems().get(0).getItem(), othello, "Wrong kh othello");

        assertEquals(item1.getAccountItems().get(0).getAccount(), owner, "Wrong hamlet dm");
        assertEquals(item2.getAccountItems().get(0).getAccount(), owner, "Wrong othello dm");
        assertEquals(item2.getAccountItems().get(1).getAccount(), coOwner, "Wrong othello kh");
    }

    @AfterEach
    public void tearDown() {
        tx.commit();
    }

    @AfterAll
    static void afterAll() {
        em.close();
    }
}