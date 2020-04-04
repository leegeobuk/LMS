package woowa.lms.front.behavior.user;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.domain.account.User;
import woowa.lms.back.service.account.AccountService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.DialogController;
import woowa.lms.front.controller.FormController;
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
        List<TextField> fields = AddUserForm.FORM.getFields();
        String id = fields.get(0).getText();
        String pw = fields.get(1).getText();
        String name = fields.get(3).getText();
        String contact = fields.get(4).getText();
        User user = User.of(id, pw, name, contact);
        try {
            accountService.signUpAccount(user);
            UserTable.getInstance().update();
            FormController.getController().closeAddUserForm();
        } catch (IllegalStateException e) {
            DialogController.getController().showSignUpErrorDialog();
        }
    }
}
