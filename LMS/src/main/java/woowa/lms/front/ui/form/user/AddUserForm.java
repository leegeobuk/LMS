package woowa.lms.front.ui.form.user;

import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.ui.form.SignUpForm;

import static woowa.lms.front.behavior.BehaviorType.ADD_USER;
import static woowa.lms.front.behavior.BehaviorType.CLOSE_ADD_USER;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_CANCEL;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_OK;

public class AddUserForm extends SignUpForm {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 450;
    private static final String TITLE = "Add User";
    public static final AddUserForm FORM = new AddUserForm(TITLE);

    private AddUserForm(String title) {
        super(WIDTH, HEIGHT);
        setUpComponents(title);
        setUpPage();
        setFoolProof();
        setUpStage(title);
    }

    @Override
    public void setUpComponents(String pageTitle) {
        okButton = GeneralButton.getFormButton(FORM_BUTTON_OK, ADD_USER);
        cancelButton = GeneralButton.getFormButton(FORM_BUTTON_CANCEL, CLOSE_ADD_USER);
        super.setUpComponents(pageTitle);
    }
}
