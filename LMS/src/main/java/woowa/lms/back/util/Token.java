package woowa.lms.back.util;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import woowa.lms.back.domain.account.Account;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Token {

    private Account account;
    private boolean signedIn;

    private static final Token TOKEN = new Token();

    public static Token getToken() {
        return TOKEN;
    }

    public void signIn(Account account) {
        this.account = account;
        signedIn = true;
    }

    public void signOut() {
        account = null;
        signedIn = false;
    }
}
