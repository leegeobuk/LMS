package woowa.lms.front.ui.form.user;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import woowa.lms.front.behavior.BehaviorType;
import woowa.lms.front.behavior.user.EditUser;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.ui.form.AbstractForm;

import java.util.List;

import static woowa.lms.front.behavior.BehaviorType.*;
import static woowa.lms.front.component.image.ImageBuilder.*;
import static woowa.lms.front.component.textfield.InputType.TEXT;
import static woowa.lms.front.foolproof.FoolProofType.CONTACT;
import static woowa.lms.front.foolproof.FoolProofType.NAME;

public class EditUserForm extends AbstractForm {

    private Label nameLabel;
    private Label contactLabel;
    private InputField nameInputField = InputField.of(TEXT, NAME, "");
    private InputField contactInputField = InputField.of(TEXT, CONTACT, "");

    private static final double WIDTH = 400;
    private static final double HEIGHT = 400;
    private static final String TITLE = "Edit User";
    public static final EditUserForm FORM = new EditUserForm(TITLE);

    private EditUserForm(String title) {
        super(WIDTH, HEIGHT);
        inputFields = List.of(nameInputField, contactInputField);
        setUpComponents(title);
        setUpPage();
        setFoolProof();
        setUpStage(title);
    }

    @Override
    public void setUpComponents(String pageTitle) {
        nameLabel = LabelBuilder.getFormLabel("Name");
        contactLabel = LabelBuilder.getFormLabel("Contact");
        okButton = GeneralButton.getFormButton(FORM_BUTTON_OK, EDIT_USER);
        cancelButton = GeneralButton.getFormButton(FORM_BUTTON_CANCEL, CLOSE_ABOUT);
        super.setUpComponents(pageTitle);
    }

    @Override
    public void setUpPage() {
        form.addRow(0, nameLabel, nameInputField.toTextField());
        form.addRow(1, contactLabel, contactInputField.toTextField());
        form.add(errorLabel, 0, 2, 2, 4);
        form.setHgap(this.getWidth() * 0.08);
        form.setVgap(this.getHeight() * 0.02);
        form.setAlignment(Pos.CENTER);
        super.setUpPage();
    }
}
