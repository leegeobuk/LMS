package woowa.lms.back.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import woowa.lms.back.domain.account.Account;

@AllArgsConstructor
@Getter
public class AccountSearchCriteria implements SearchCriteria<Account> {
    private String id;
    private String name;
    private String contact;
}
