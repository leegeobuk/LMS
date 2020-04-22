package woowa.lms.back.repository.account;

import woowa.lms.back.domain.account.Account;
import woowa.lms.back.search.AccountSearchCriteria;

import java.util.List;

public interface CustomAccountRepository {
    List<Account> search(AccountSearchCriteria criteria);
}
