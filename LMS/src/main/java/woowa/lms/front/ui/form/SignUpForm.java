package woowa.lms.front.ui.form;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import woowa.lms.front.behavior.BehaviorType;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.font.FontBuilder;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.foolproof.FormFoolProof;

import java.util.List;

import static javafx.scene.control.ContentDisplay.GRAPHIC_ONLY;
import static woowa.lms.front.component.image.ImageType.*;
import static woowa.lms.front.component.textfield.InputType.PASSWORD;
import static woowa.lms.front.component.textfield.InputType.TEXT;
import static woowa.lms.front.foolproof.FoolProofType.*;

public class SignUpForm extends AbstractForm {

//    private Scene scene;
//    private VBox mainPane;
//    private Background background;
//
//    private Label headerLabel;
//    private ImageView logoImageView;

//    private GridPane form;
    private Label idLabel;
    private Label pwLabel;
    private Label confirmPwLabel;
    private Label nameLabel;
    private Label contactLabel;
    private InputField idInputField;
    private InputField pwInputField;
    private InputField confirmPwInputField;
    private InputField nameInputField;
    private InputField contactInputField;
    private TextField idField;
    private TextField pwField;
    private TextField confirmPwField;
    private TextField nameField;
    private TextField contactField;
    private Label errorLabel;

//    private HBox buttonBox;
//    private Button okButton;
//    private Button cancelButton;

    private double imageWidth;

    public static final SignUpForm INSTANCE = new SignUpForm(400, 450);

//    private SignUpForm() {
//        mainPane = new VBox();
//        scene = new Scene(mainPane, 400, 450);
//        mainPane.setSpacing(scene.getHeight() * 0.1);
//
//        form = new GridPane();
//
//        buttonBox = new HBox(10);
//
//        imageWidth = scene.getWidth() * 0.16;
//
//        setUpComponents();
//        setUpPage();
//        setFoolProof();
//    }


    private SignUpForm(double width, double height) {
        super(width, height);
        idInputField = InputField.of(TEXT, ID_FIELD);
        pwInputField = InputField.of(PASSWORD, PW_FIELD);
        confirmPwInputField = InputField.of(PASSWORD, CONFIRM_PW_FIELD);
        nameInputField = InputField.of(TEXT, NAME_FIELD);
        contactInputField = InputField.of(TEXT, CONTACT_FIELD);
    }

    @Override
    public void setUpComponents() {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();

        headerLabel = LabelBuilder.getPageLabel("Sign Up").toLabel();

        ImageBuilder customImage = ImageBuilder.builder().imageType(LOGO)
            .width(imageWidth).height(imageWidth).build();
        logoImageView = customImage.toImageView();

        FontBuilder customFont = FontBuilder.builder().size(18).build();
        LabelBuilder customLabel = LabelBuilder.builder().font(customFont).build();
        customLabel.setText("Id");
        idLabel = customLabel.toLabel();

        customLabel.setText("Password");
        pwLabel = customLabel.toLabel();

        customLabel.setText("Confirm Password");
        confirmPwLabel = customLabel.toLabel();

        customLabel.setText("Name");
        nameLabel = customLabel.toLabel();

        customLabel.setText("Contact");
        contactLabel = customLabel.toLabel();

        idField = idInputField.toTextField();
        pwField = pwInputField.toTextField();
        confirmPwField = confirmPwInputField.toTextField();
        nameField = nameInputField.toTextField();
        contactField = contactInputField.toTextField();

        errorLabel = LabelBuilder.builder().textFill("red").build().toLabel();
        errorLabel.setWrapText(true);

        customImage.setImageType(OK);
        customImage.setWidth(48);
        customImage.setHeight(48);
        List<TextField> fields =
            List.of(idField, pwField, confirmPwField, nameField, contactField);
        GeneralButton button = GeneralButton.builder().image(customImage)
            .display(GRAPHIC_ONLY).graphicGap(0).behavior(BehaviorType.SIGN_IN)
            .fields(fields).build();
        okButton = button.toButton();
        okButton.setDisable(true);

        customImage.setImageType(CANCEL);
        button.setBehavior(BehaviorType.CLOSE);
        button.setErrorLabel(errorLabel);
        cancelButton = button.toButton();
    }

    @Override
    public void setUpPage() {
        headerLabel.setGraphic(logoImageView);
        headerLabel.setGraphicTextGap(scene.getWidth() * 0.05);

        form.addRow(0, idLabel, idField);
        form.addRow(1, pwLabel, pwField);
        form.addRow(2, confirmPwLabel, confirmPwField);
        form.addRow(3, nameLabel, nameField);
        form.addRow(4, contactLabel, contactField);
        form.add(errorLabel, 0, 5, 2, 4);
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
        confirmPwInputField.setPasswordField(pwField);
        List<InputField> inputFields = List.of(idInputField, pwInputField,
            confirmPwInputField, nameInputField, contactInputField);
        FormFoolProof formFoolProof = FormFoolProof.builder().button(okButton)
            .errorLabel(errorLabel).inputFields(inputFields).build();
        idField.setOnKeyReleased(formFoolProof);
        pwField.setOnKeyReleased(formFoolProof);
        confirmPwField.setOnKeyReleased(formFoolProof);
        nameField.setOnKeyReleased(formFoolProof);
        contactField.setOnKeyReleased(formFoolProof);
    }

    @Override
    public Stage getStage() {
        Stage signUpStage = new Stage();
        signUpStage.setScene(scene);
        signUpStage.setTitle("Sign Up");
        signUpStage.setResizable(false);
        return signUpStage;
    }
}
