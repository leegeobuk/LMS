package woowa.lms.front.behavior.user;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.service.account.AccountService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.DialogController;
import woowa.lms.front.controller.FormController;
import woowa.lms.front.controller.TableController;
import woowa.lms.front.model.AccountModel;
import woowa.lms.front.ui.form.user.EditUserForm;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EditUser implements Behavior {

    private AccountService accountService = SpringContext.getBean(AccountService.class);

    private static final EditUser INSTANCE = new EditUser();

    public static EditUser getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        AccountModel selected = EditUserForm.FORM.getSelected();
        String name = EditUserForm.FORM.getFields().get(0).getText();
        String contact = EditUserForm.FORM.getFields().get(1).getText();
        accountService.editAccount(selected.getId(), name, contact);
        TableController.getController().updateUserTable();
        Behavior.super.closeForm(event);
    }
}
