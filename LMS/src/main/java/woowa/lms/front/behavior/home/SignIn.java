package woowa.lms.front.behavior.home;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import woowa.lms.back.domain.account.Admin;
import woowa.lms.back.service.AccountService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.HomeController;
import woowa.lms.front.ui.form.SignInForm;

import java.util.List;

public class SignIn implements Behavior {

    private AccountService service = SpringContext.getBean(AccountService.class);

    private static final SignIn INSTANCE = new SignIn();

    public static SignIn getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(MouseEvent event) {
        SignInForm form = SignInForm.INSTANCE;
        List<TextField> fields = form.getFields();
        String id = fields.get(0).getText();
        String pw = fields.get(1).getText();
        Admin admin = Admin.of(id, pw);
        HomeController controller = HomeController.getController();
        try {
            service.signIn(admin);
            //Change MainPage signIn button to signOut
            controller.closeSignUpForm();
        } catch (IllegalStateException e) {
            controller.showSignInErrorDialog();
        }
    }
}
