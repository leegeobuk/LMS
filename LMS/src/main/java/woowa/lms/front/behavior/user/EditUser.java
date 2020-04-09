package woowa.lms.front.behavior.user;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.service.account.AccountService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.MainController;
import woowa.lms.front.model.AccountModel;
import woowa.lms.front.ui.form.user.EditUserForm;
import woowa.lms.front.ui.table.UserTable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EditUser implements Behavior {

    private AccountService accountService = SpringContext.getBean(AccountService.class);

    private static final EditUser INSTANCE = new EditUser();

    public static EditUser getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        AccountModel selected = UserTable.getInstance().getSelected();
        String name = EditUserForm.getForm().getFields().get(0).getText();
        String contact = EditUserForm.getForm().getFields().get(1).getText();
        accountService.editAccount(selected.getId(), name, contact);
        UserTable.getInstance().update();
        MainController.getController().close(event);
    }
}
