package woowa.lms.front.component.button.behavior.home;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.util.SpringContext;
import woowa.lms.back.controller.HomeController;
import woowa.lms.back.domain.account.Admin;
import woowa.lms.back.service.AccountService;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.button.behavior.Behavior;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignIn implements Behavior {

    private AccountService service = SpringContext.getBean(AccountService.class);

    private static final SignIn INSTANCE = new SignIn();

    public static SignIn getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(MouseEvent event) {
        GeneralButton source = (GeneralButton) event.getSource();
        List<TextField> fields = source.getFields();
        String id = fields.get(0).getText();
        String pw = fields.get(1).getText();
        String name = fields.get(3).getText();
        String contact = fields.get(4).getText();
        Admin admin = Admin.of(id, pw);
        admin.setName(name);
        admin.setContact(contact);
        service.signUp(admin);
        HomeController.closeSignUpForm();
    }
}
