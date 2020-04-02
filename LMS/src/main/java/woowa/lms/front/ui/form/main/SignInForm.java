package woowa.lms.front.ui.form.main;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.ui.form.AbstractForm;

import java.util.List;

import static woowa.lms.front.behavior.BehaviorType.CLOSE_SIGN_IN;
import static woowa.lms.front.behavior.BehaviorType.SIGN_IN;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_CANCEL;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_OK;
import static woowa.lms.front.component.textfield.InputType.PASSWORD;
import static woowa.lms.front.component.textfield.InputType.TEXT;
import static woowa.lms.front.foolproof.FoolProofType.SIGN_IN_ID;
import static woowa.lms.front.foolproof.FoolProofType.SIGN_IN_PW;

public class SignInForm extends AbstractForm {

    private Label idLabel;
    private Label pwLabel;
    private InputField idInputField = InputField.of(TEXT, SIGN_IN_ID, "ID");
    private InputField pwInputField = InputField.of(PASSWORD, SIGN_IN_PW, "Password");

    private static final double WIDTH = 400;
    private static final double HEIGHT = 300;
    public static final SignInForm FORM = new SignInForm(WIDTH, HEIGHT);

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

        okButton = GeneralButton.getFormButton(FORM_BUTTON_OK, SIGN_IN);
        cancelButton = GeneralButton.getFormButton(FORM_BUTTON_CANCEL, CLOSE_SIGN_IN);
        super.setUpComponents(pageTitle);
    }

    @Override
    public void setUpPage() {
        form.addRow(0, idLabel, idInputField.toTextField());
        form.addRow(1, pwLabel, pwInputField.toTextField());
        form.add(errorLabel, 0, 2, 2, 2);
        form.setHgap(this.getWidth() * 0.15);
        form.setVgap(this.getHeight() * 0.02);
        form.setAlignment(Pos.CENTER);

        super.setUpPage();
    }
}
