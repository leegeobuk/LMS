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
        setUpComponents();
        setUpPage();
        setFoolProof();
        setUpStage();
    }

    @Override
    public void setUpComponents() {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();

        headerLabel = LabelBuilder.getPageHeader("Sign In");

        logoImageView = getLogo(imageWidth);

        idLabel = LabelBuilder.getFormLabel("Id");
        pwLabel = LabelBuilder.getFormLabel("Password");
        errorLabel = LabelBuilder.builder().textFill("red").build().toLabel();
        errorLabel.setWrapText(true);

        okButton = GeneralButton.getFormButton(FORM_BUTTON_OK, SIGN_IN);
        okButton.setDefaultButton(true);
        okButton.setDisable(true);

        cancelButton = GeneralButton.getFormButton(FORM_BUTTON_CANCEL, CLOSE_SIGN_IN);
        cancelButton.setCancelButton(true);
    }

    @Override
    public void setUpPage() {
        headerLabel.setGraphic(logoImageView);
        headerLabel.setGraphicTextGap(this.getWidth() * 0.05);

        form.addRow(0, idLabel, idInputField.toTextField());
        form.addRow(1, pwLabel, pwInputField.toTextField());
        form.add(errorLabel, 0, 2, 2, 2);
        form.setHgap(this.getWidth() * 0.15);
        form.setVgap(this.getHeight() * 0.02);
        form.setAlignment(Pos.CENTER);

        buttonBox.getChildren().addAll(okButton, cancelButton);
        buttonBox.setAlignment(Pos.CENTER);

        mainPane.setBackground(background);
        mainPane.getChildren().addAll(headerLabel, form, buttonBox);
        mainPane.setPadding(new Insets(20));
        mainPane.setAlignment(Pos.CENTER);
    }

    @Override
    public void setFoolProof() {
        FormFoolProof formFoolProof = FormFoolProof.builder().button(okButton)
            .errorLabel(errorLabel).inputFields(inputFields).build();
        inputFields.forEach(inputField -> inputField.setOnKeyReleased(formFoolProof));
    }

    @Override
    public void setUpStage() {
        super.setUpStage();
        this.setTitle("Sign In");
    }
}
