package woowa.lms.front.component.label;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.ui.form.AbstractForm;

import static woowa.lms.front.component.textfield.InputType.PASSWORD;
import static woowa.lms.front.component.textfield.InputType.TEXT;
import static woowa.lms.front.foolproof.FoolProofType.*;

public class SignInForm extends AbstractForm {

    private GridPane form;
    private Label idLabel;
    private Label pwLabel;
    private InputField idInputField = InputField.of(TEXT, SIGN_UP_ID);
    private InputField pwInputField = InputField.of(PASSWORD, SIGN_UP_PW);
    private TextField idField;
    private TextField pwField;

    public SignInForm(double width, double height) {
        super(width, height);
    }

    @Override
    public void setUpComponents() {

    }

    @Override
    public void setUpPage() {

    }

    @Override
    public void setFoolProof() {

    }

    @Override
    public Stage getStage() {
        return null;
    }
}
