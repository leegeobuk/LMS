package woowa.lms.back.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import woowa.lms.back.domain.account.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String >, CustomAccountRepository {

    @Query("SELECT a FROM Account a WHERE type(a) = Admin")
    List<Account> findAdmins();

    @Query("SELECT a FROM Account a WHERE type(a) = User")
    List<Account> findUsers();
}
