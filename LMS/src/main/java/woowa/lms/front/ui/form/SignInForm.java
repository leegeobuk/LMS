package woowa.lms.front.ui.form;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.component.textfield.InputField;

import java.util.List;

import static woowa.lms.front.behavior.BehaviorType.*;
import static woowa.lms.front.component.image.ImageBuilder.*;
import static woowa.lms.front.component.textfield.InputType.PASSWORD;
import static woowa.lms.front.component.textfield.InputType.TEXT;
import static woowa.lms.front.foolproof.FoolProofType.ID_FIELD;
import static woowa.lms.front.foolproof.FoolProofType.PW_FIELD;

public class SignInForm extends AbstractForm {

    private Label idLabel;
    private Label pwLabel;
    private InputField idInputField = InputField.of(TEXT, ID_FIELD);
    private InputField pwInputField = InputField.of(PASSWORD, PW_FIELD);

    public static final SignInForm INSTANCE = new SignInForm(400, 400);

    private SignInForm(double width, double height) {
        super(width, height);
        inputFields = List.of(idInputField, pwInputField);
        setUpComponents();
        setUpPage();
        setFoolProof();
    }

    @Override
    public void setUpComponents() {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();

        headerLabel = LabelBuilder.getPageLabel("Sign In");

        logoImageView = getLogo(imageWidth);

        idLabel = LabelBuilder.getFormLabel("Id");
        pwLabel = LabelBuilder.getFormLabel("Password");

        okButton = GeneralButton.getFormButton(FORM_BUTTON_OK, SIGN_IN);
        okButton.setDisable(true);

        cancelButton = GeneralButton.getFormButton(FORM_BUTTON_CANCEL, CLOSE_SIGN_IN);
    }

    @Override
    public void setUpPage() {
        headerLabel.setGraphic(logoImageView);
        headerLabel.setGraphicTextGap(scene.getWidth() * 0.05);

        form.addRow(0, idLabel, idInputField.toTextField());
        form.addRow(1, pwLabel, pwInputField.toTextField());
        form.setHgap(scene.getWidth() * 0.115);
        form.setVgap(scene.getHeight() * 0.02);
        form.setAlignment(Pos.CENTER);

        buttonBox.getChildren().addAll(okButton, cancelButton);
        buttonBox.setAlignment(Pos.CENTER);

        mainPane.setBackground(background);
        mainPane.getChildren().addAll(headerLabel, form, buttonBox);
        mainPane.setPadding(new Insets(20));
        mainPane.setAlignment(Pos.TOP_CENTER);
    }

    @Override
    public void setFoolProof() {

    }

    @Override
    public Stage getStage() {
        stage.setScene(scene);
        stage.setTitle("Sign In");
        stage.setResizable(false);
        return stage;
    }
}
