package woowa.lms.back.service.account;

import woowa.lms.back.domain.account.Account;

public interface Signable<T extends Account> {
    T signIn(T account) throws IllegalStateException;
}
