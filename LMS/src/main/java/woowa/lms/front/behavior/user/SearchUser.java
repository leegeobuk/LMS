package woowa.lms.front.behavior.user;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.search.AccountSearchCriteria;
import woowa.lms.back.service.account.AccountService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.MainController;
import woowa.lms.front.controller.account.AccountFormController;
import woowa.lms.front.model.AccountModel;
import woowa.lms.front.ui.form.user.SearchUserForm;
import woowa.lms.front.ui.table.UserTable;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchUser implements Behavior {

    private AccountService accountService = SpringContext.getBean(AccountService.class);

    private static final SearchUser INSTANCE = new SearchUser();

    public static SearchUser getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        AccountFormController.getController().searchUserAndClose(event);
    }
}
