package woowa.lms.domain;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import woowa.lms.db.DB;
import woowa.lms.domain.account.*;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    static EntityManager em = DB.getEntityManager();
    static final String OWNER = "Lee,DM";
    static final String ADMIN = "Yoon,KH";
    static final String CUSTOMER = "KoJG";
    static final String PW = "password";

    static Owner owner;
    static Admin admin;
    static Customer customer;

    @BeforeAll
    static void beforeAll() {
        owner = Owner.of(OWNER, PW);
        owner.setName(OWNER.substring(OWNER.length() - 2));
        owner.setContact("01096990080");
        admin = Admin.of(ADMIN, PW);
        admin.setName(ADMIN.substring(ADMIN.length() - 2));
        admin.setContact("01012345677");
        customer = Customer.of(CUSTOMER, PW);
        customer.setName(CUSTOMER.substring(CUSTOMER.length() - 2));
        customer.setContact("01013365997");

        em.persist(owner);
        em.persist(admin);
        em.persist(customer);
    }

    @Test
    void testGetters() {
        Account owner = em.find(Owner.class, OWNER);
        Account admin = em.find(Admin.class, ADMIN);
        Account customer = em.find(Customer.class, CUSTOMER);

        assertAll("Test getters",
            () -> {
                assertEquals(OWNER, owner.getId(), "Wrong owner getId");
                assertEquals(AccountType.OWNER, owner.getAccountType(), "Wrong owner getAccountType");
                assertEquals(OWNER.substring(OWNER.length() - 2), owner.getName(), "Wrong owner getName");
                assertEquals("01096990080", owner.getContact(), "Wrong owner getContact");
            },
            () -> {
                assertEquals(ADMIN, admin.getId(), "Wrong admin getId");
                assertEquals(AccountType.ADMIN, admin.getAccountType(), "Wrong admin getAccountType");
                assertEquals(ADMIN.substring(ADMIN.length() - 2), admin.getName(), "Wrong admin getName");
                assertEquals("01012345677", admin.getContact(), "Wrong admin getContact");
            },
            () -> {
                assertEquals(CUSTOMER, customer.getId(), "Wrong customer getId");
                assertEquals(AccountType.CUSTOMER, customer.getAccountType(), "Wrong customer getAccountType");
                assertEquals(CUSTOMER.substring(CUSTOMER.length() - 2), customer.getName(), "Wrong customer getName");
                assertEquals("01013365997", customer.getContact(), "Wrong customer getContact");
            });
    }

    @Test
    void testSetters() {
        Account owner = em.find(Owner.class, OWNER);
        owner.setName("Dongmin");
        Account admin = em.find(Admin.class, ADMIN);
        admin.setName("Kyeonghee");
        Account customer = em.find(Customer.class, CUSTOMER);
        customer.setName("Jeonggoo");

        assertAll("Test setters",
            () -> {
                assertEquals("Dongmin", owner.getName(), "Wrong owner setName");
            },
            () -> {
                assertEquals("Kyeonghee", admin.getName(), "Wrong admin setName");
            },
            () -> {
                assertEquals("Jeonggoo", customer.getName(), "Wrong customer setName");
            });
    }

    @AfterAll
    static void afterAll() {
        em.remove(owner);
        em.remove(admin);
        em.remove(customer);

        em.close();
    }
}