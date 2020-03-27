package woowa.lms.front.behavior.sign;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.domain.account.Admin;
import woowa.lms.back.service.AccountService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.HomeController;
import woowa.lms.front.ui.form.SignUpForm;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUp implements Behavior {

    private AccountService service = SpringContext.getBean(AccountService.class);

    private static final SignUp INSTANCE = new SignUp();

    public static SignUp getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        SignUpForm form = SignUpForm.FORM;
        List<TextField> fields = form.getFields();
        String id = fields.get(0).getText();
        String pw = fields.get(1).getText();
        String name = fields.get(3).getText();
        String contact = fields.get(4).getText();
        Admin admin = Admin.of(id, pw);
        admin.setName(name);
        admin.setContact(contact);
        HomeController controller = HomeController.getController();
        try {
            service.signUp(admin);
            controller.showSignUpSuccessfulDialog();
            controller.closeSignUpForm();
        } catch (IllegalStateException e) {
            controller.showSignUpErrorDialog();
        }
    }
}
