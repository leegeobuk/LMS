package woowa.lms.back.repository.account;

import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.search.AccountSearchCriteria;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

//@Repository
//@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomAccountRepositoryImpl implements CustomAccountRepository {

    private final EntityManager em;

    @Override
    public List<Account> search(AccountSearchCriteria criteria) {
        String jpql = "SELECT a FROM Account a";
        boolean prevCondition = false;
        if (StringUtils.hasText(criteria.getId())) {
            prevCondition = true;
            jpql += " WHERE a.id LIKE :id";
        }
        if (StringUtils.hasText(criteria.getName())) {
            jpql += prevCondition ? " AND" : " WHERE";
            jpql += " a.name LIKE :name";
            prevCondition = true;
        }
        if (StringUtils.hasText(criteria.getContact())) {
            jpql += prevCondition ? " AND" : " WHERE";
            jpql += " a.contact LIKE :contact";
        }

        TypedQuery<Account> query = em.createQuery(jpql, Account.class);
        if (jpql.contains(":id")) {
            query.setParameter("id", criteria.getId());
        }
        if (jpql.contains(":name")) {
            query.setParameter("name", criteria.getName());
        }
        if (jpql.contains(":contact")) {
            query.setParameter("contact", criteria.getContact());
        }
        return query.getResultList();
    }
}
