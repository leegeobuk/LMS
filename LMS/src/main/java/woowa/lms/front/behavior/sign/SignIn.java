package woowa.lms.front.behavior.sign;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.Admin;
import woowa.lms.back.service.account.AdminService;
import woowa.lms.back.service.account.Signable;
import woowa.lms.back.util.SpringContext;
import woowa.lms.back.util.Token;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.HomeController;
import woowa.lms.front.ui.form.SignInForm;

import java.util.List;

public class SignIn implements Behavior {

    private Signable<Admin> service = SpringContext.getBean(AdminService.class);

    private static final SignIn INSTANCE = new SignIn();

    public static SignIn getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        SignInForm form = SignInForm.FORM;
        List<TextField> fields = form.getFields();
        String id = fields.get(0).getText();
        String pw = fields.get(1).getText();
        Admin admin = Admin.of(id, pw);
        HomeController controller = HomeController.getController();
        try {
            Account account = service.signIn(admin);
            Token.getToken().signIn(account);
            controller.redrawMainPage();
            controller.closeSignInForm();
        } catch (IllegalStateException e) {
            controller.showSignInErrorDialog(e.getMessage());
        }
    }
}
