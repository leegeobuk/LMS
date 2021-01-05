package woowa.lms.front.ui.form.user;

import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.ui.form.SignUpForm;
import woowa.lms.front.ui.table.UserTable;

import static woowa.lms.front.behavior.BehaviorType.ADD_USER;
import static woowa.lms.front.behavior.BehaviorType.CLOSE;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_CANCEL;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_OK;

public class AddUserForm extends SignUpForm {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 450;
    private static final String TITLE = "Add User Form";
    private static final String HEADER = "Add User";
    private static final AddUserForm FORM = new AddUserForm();

    private AddUserForm() {
        super(WIDTH, HEIGHT, TITLE, HEADER);
        setUpComponents();
        setUpPage();
        setFoolProof();
        setUpStage();
    }

    public static AddUserForm getForm() {
        return FORM;
    }

    @Override
    public void setUpComponents() {
        okButton = GeneralButton.getFormButton(FORM_BUTTON_OK, ADD_USER);
        cancelButton = GeneralButton.getFormButton(FORM_BUTTON_CANCEL, CLOSE);
        super.setUpComponents();
    }

    @Override
    public void setUpStage() {
        super.setUpStage();
        this.initOwner(UserTable.getTable());
    }
}
