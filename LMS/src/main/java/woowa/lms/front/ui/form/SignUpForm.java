package woowa.lms.front.ui.form;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.ui.form.AbstractForm;

import java.util.List;

import static woowa.lms.front.behavior.BehaviorType.CLOSE_SIGN_UP;
import static woowa.lms.front.behavior.BehaviorType.SIGN_UP;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_CANCEL;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_OK;
import static woowa.lms.front.component.textfield.InputType.PASSWORD;
import static woowa.lms.front.component.textfield.InputType.TEXT;
import static woowa.lms.front.foolproof.FoolProofType.*;

public class SignUpForm extends AbstractForm {

    protected Label idLabel;
    protected Label pwLabel;
    protected Label confirmPwLabel;
    protected Label nameLabel;
    protected Label contactLabel;
    protected InputField idInputField = InputField.of(TEXT, SIGN_UP_ID, "ID");
    protected InputField pwInputField = InputField.of(PASSWORD, SIGN_UP_PW, "Password");
    protected InputField confirmPwInputField = InputField.of(PASSWORD, SIGN_UP_CONFIRM_PW, "Confirm password");
    protected InputField nameInputField = InputField.of(TEXT, NAME, "Name");
    protected InputField contactInputField = InputField.of(TEXT, CONTACT, "Enter without -");

    public SignUpForm(double width, double height) {
        super(width, height);
        inputFields = List.of(idInputField, pwInputField,
            confirmPwInputField, nameInputField, contactInputField);
    }

    @Override
    public void setUpComponents(String pageTitle) {
        idLabel = LabelBuilder.getFormLabel("Id");
        pwLabel = LabelBuilder.getFormLabel("Password");
        confirmPwLabel = LabelBuilder.getFormLabel("Confirm Password");
        nameLabel = LabelBuilder.getFormLabel("Name");
        contactLabel = LabelBuilder.getFormLabel("Contact");
        super.setUpComponents(pageTitle);
    }

    @Override
    public void setUpPage() {
        form.addRow(0, idLabel, idInputField.toTextField());
        form.addRow(1, pwLabel, pwInputField.toTextField());
        form.addRow(2, confirmPwLabel, confirmPwInputField.toTextField());
        form.addRow(3, nameLabel, nameInputField.toTextField());
        form.addRow(4, contactLabel, contactInputField.toTextField());
        form.add(errorLabel, 0, 5, 2, 4);
        form.setHgap(this.getWidth() * 0.08);
        form.setVgap(this.getHeight() * 0.02);
        form.setAlignment(Pos.CENTER);
        super.setUpPage();
    }

    @Override
    public void setFoolProof() {
        confirmPwInputField.setPasswordField(pwInputField);
        super.setFoolProof();
    }
}
