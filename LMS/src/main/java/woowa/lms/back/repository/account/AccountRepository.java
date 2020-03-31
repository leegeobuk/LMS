package woowa.lms.back.repository.account;

import woowa.lms.back.domain.account.Account;

import java.util.List;

public interface AccountRepository<T extends Account> {
    void save(T account);
    Account findById(String id);
    List<Account> findByName(String name);
    List<Account> findAll();
}
