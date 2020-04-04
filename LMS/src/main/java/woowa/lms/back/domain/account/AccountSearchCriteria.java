package woowa.lms.back.domain.account;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccountSearchCriteria {
    private String id;
    private String name;
    private String contact;
}
