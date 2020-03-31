package woowa.lms.back.service.account;

import woowa.lms.back.domain.account.Account;

import java.util.List;

public interface AccountService<T extends Account> {
    String signUp(T account) throws IllegalStateException;
    void edit(String id, String name, String contact);
    T find(String id);
    List<T> findAll();
}
