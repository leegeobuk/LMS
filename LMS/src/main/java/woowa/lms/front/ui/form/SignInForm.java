package woowa.lms.front.ui.form;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.foolproof.FormFoolProof;

import java.util.List;

import static woowa.lms.front.behavior.BehaviorType.CLOSE_SIGN_IN;
import static woowa.lms.front.behavior.BehaviorType.SIGN_IN;
import static woowa.lms.front.component.image.ImageBuilder.*;
import static woowa.lms.front.component.textfield.InputType.PASSWORD;
import static woowa.lms.front.component.textfield.InputType.TEXT;
import static woowa.lms.front.foolproof.FoolProofType.SIGN_IN_ID;
import static woowa.lms.front.foolproof.FoolProofType.SIGN_IN_PW;

public class SignInForm extends AbstractForm {

    private Label idLabel;
    private Label pwLabel;
    private InputField idInputField = InputField.of(TEXT, SIGN_IN_ID, "ID");
    private InputField pwInputField = InputField.of(PASSWORD, SIGN_IN_PW, "Password");

    public static final SignInForm FORM = new SignInForm(400, 300);

    private SignInForm(double width, double height) {
        super(width, height);
        inputFields = List.of(idInputField, pwInputField);
        String headerText = "Sign In";
        setUpComponents(headerText);
        setUpPage();
        setFoolProof();
        setUpStage(headerText);
    }

    @Override
    public void setUpComponents(String pageTitle) {
        idLabel = LabelBuilder.getFormLabel("Id");
        pwLabel = LabelBuilder.getFormLabel("Password");
        errorLabel = LabelBuilder.builder().textFill("red").build().toLabel();

        okButton = GeneralButton.getFormButton(FORM_BUTTON_OK, SIGN_IN);
        cancelButton = GeneralButton.getFormButton(FORM_BUTTON_CANCEL, CLOSE_SIGN_IN);
        super.setUpComponents(pageTitle);
    }

    @Override
    public void setUpPage() {
        super.setUpPage();

        form.addRow(0, idLabel, idInputField.toTextField());
        form.addRow(1, pwLabel, pwInputField.toTextField());
        form.add(errorLabel, 0, 2, 2, 2);
        form.setHgap(this.getWidth() * 0.15);
        form.setVgap(this.getHeight() * 0.02);
        form.setAlignment(Pos.CENTER);
    }
}
