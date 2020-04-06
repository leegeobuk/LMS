package woowa.lms.front.behavior.main.sign;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.domain.account.Admin;
import woowa.lms.back.service.account.AccountService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.DialogController;
import woowa.lms.front.controller.FormController;
import woowa.lms.front.ui.form.main.MainSignUpForm;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUp implements Behavior {

    private AccountService accountService = SpringContext.getBean(AccountService.class);

    private static final SignUp INSTANCE = new SignUp();

    public static SignUp getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        List<TextField> fields = MainSignUpForm.FORM.getFields();
        String id = fields.get(0).getText();
        String pw = fields.get(1).getText();
        String name = fields.get(3).getText();
        String contact = fields.get(4).getText();
        Admin admin = Admin.of(id, pw, name, contact);
        DialogController controller = DialogController.getController();
        try {
            accountService.signUpAccount(admin);
            controller.showSignUpSuccessfulDialog();
            Behavior.super.closeForm(event);
        } catch (IllegalStateException e) {
            controller.showSignUpErrorDialog();
        }
    }
}
