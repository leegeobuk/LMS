package woowa.lms.front.component.label;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.ui.form.AbstractForm;
import woowa.lms.front.ui.form.CustomForm;

import static woowa.lms.front.component.textfield.InputType.PASSWORD;
import static woowa.lms.front.component.textfield.InputType.TEXT;
import static woowa.lms.front.foolproof.FoolProofType.*;

public class SignInForm extends AbstractForm {

    private GridPane form;
    private Label idLabel;
    private Label pwLabel;
    private InputField idInputField = InputField.of(TEXT, ID_FIELD);
    private InputField pwInputField = InputField.of(PASSWORD, PW_FIELD);
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
