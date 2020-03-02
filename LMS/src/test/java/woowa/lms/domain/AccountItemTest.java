package woowa.lms.domain;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import woowa.lms.db.DB;
import woowa.lms.domain.account.Account;
import woowa.lms.domain.account.Owner;
import woowa.lms.domain.item.Book;
import woowa.lms.domain.item.Item;
import woowa.lms.domain.item.ItemStatus;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountItemTest {
    static EntityManager em = DB.getEntityManager();
    static EntityTransaction tx;
    static final String OWNER = "LeeDM";
    static final String CO_OWNER = "YoonKH";
    static final String HAMLET = "Hamlet";
    static final String OTHELLO = "Othello";
    static final String SHAKESPEARE = "Shakespeare";
    static final String PW = "password";

    static Account dm;
    static Account kh;
    static AccountItem dmHamlet;
    static AccountItem dmOthello;
    static AccountItem khOthello;
    static Item hamlet;
    static Item othello;

    @BeforeAll
    static void beforeAll() {
        dm = Owner.of(OWNER, PW);
        dm.setName(OWNER.substring(OWNER.length() - 2));
        dm.setContact("01096990080");
        kh = Owner.of(CO_OWNER, PW);
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

        dmHamlet = AccountItem.of(dm, hamlet);
        dmOthello = AccountItem.of(dm, othello);
        khOthello = AccountItem.of(kh, othello);

        em.persist(dm);
        em.persist(kh);
        em.persist(hamlet);
        em.persist(othello);
        em.persist(dmHamlet);
        em.persist(dmOthello);
        em.persist(khOthello);
    }

    @Test
    public void testAccountItemRelation() {
        Account owner = em.find(Owner.class, OWNER);
        Account coOwner = em.find(Owner.class, CO_OWNER);

        Item item1 = em.find(Item.class, hamlet.getId());
        Item item2 = em.find(Item.class, othello.getId());

        assertEquals(owner.getAccountItems().get(0).getItem(), hamlet, "Wrong dm hamlet");
        assertEquals(owner.getAccountItems().get(1).getItem(), othello, "Wrong dm othello");
        assertEquals(coOwner.getAccountItems().get(0).getItem(), othello, "Wrong kh othello");

        assertEquals(item1.getAccountItems().get(0).getAccount(), owner, "Wrong hamlet dm");
        assertEquals(item2.getAccountItems().get(0).getAccount(), owner, "Wrong othello dm");
        assertEquals(item2.getAccountItems().get(1).getAccount(), coOwner, "Wrong othello kh");
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

        em.close();
    }
}