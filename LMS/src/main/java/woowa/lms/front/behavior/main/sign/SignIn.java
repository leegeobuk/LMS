package woowa.lms.front.behavior.main.sign;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.Admin;
import woowa.lms.back.service.account.AccountService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.back.util.Token;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.DialogController;
import woowa.lms.front.controller.FormController;
import woowa.lms.front.controller.MainController;
import woowa.lms.front.ui.form.main.SignInForm;

import java.util.List;

public class SignIn implements Behavior {

    private AccountService accountService = SpringContext.getBean(AccountService.class);

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
        try {
            Account account = accountService.signInAccount(admin);
            Token.getToken().signIn(account);
            MainController.getController().redrawMainPage();
            Behavior.super.closeForm(event);
        } catch (IllegalStateException e) {
            DialogController.getController().showSignInErrorDialog(e.getMessage());
        }
    }
}
