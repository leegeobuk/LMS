package woowa.lms.front.ui.form.main;

import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.ui.form.SignUpForm;
import woowa.lms.front.ui.page.MainPage;

import static woowa.lms.front.behavior.BehaviorType.CLOSE;
import static woowa.lms.front.behavior.BehaviorType.SIGN_UP;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_CANCEL;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_OK;

public class MainSignUpForm extends SignUpForm {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 450;
    private static final String TITLE = "Sign Up Form";
    private static final String HEADER = "Sign Up";
    private static final MainSignUpForm FORM = new MainSignUpForm();

    private MainSignUpForm() {
        super(WIDTH, HEIGHT, TITLE, HEADER);
        setUpComponents();
        setUpPage();
        setFoolProof();
        setUpStage();
    }

    public static MainSignUpForm getForm() {
        return FORM;
    }

    @Override
    public void setUpComponents() {
        okButton = GeneralButton.getFormButton(FORM_BUTTON_OK, SIGN_UP);
        cancelButton = GeneralButton.getFormButton(FORM_BUTTON_CANCEL, CLOSE);
        super.setUpComponents();
    }

    @Override
    public void setUpStage() {
        super.setUpStage();
        this.initOwner(MainPage.getPage());
    }
}
