package woowa.lms.front.behavior.user;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.domain.account.User;
import woowa.lms.back.service.account.AccountService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.MainController;
import woowa.lms.front.controller.account.AccountDialogController;
import woowa.lms.front.controller.account.AccountFormController;
import woowa.lms.front.ui.form.user.AddUserForm;
import woowa.lms.front.ui.table.UserTable;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddUser implements Behavior {

    private AccountService accountService = SpringContext.getBean(AccountService.class);

    private static final AddUser INSTANCE = new AddUser();

    public static AddUser getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        AccountFormController.getController().addUserAndClose(event);
    }
}
