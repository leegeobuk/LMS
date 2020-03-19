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
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.button.behavior.BehaviorType;
import woowa.lms.front.component.font.FontBuilder;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.component.textfield.foolproof.signup.SignUpFoolProof;
import woowa.lms.front.component.label.LabelBuilder;

import java.util.List;

import static javafx.scene.control.ContentDisplay.GRAPHIC_ONLY;
import static woowa.lms.front.component.font.FontType.EULJIRO;
import static woowa.lms.front.component.font.FontType.HANNA_11;
import static woowa.lms.front.component.image.ImageType.*;
import static woowa.lms.front.component.textfield.InputType.PASSWORD;
import static woowa.lms.front.component.textfield.InputType.TEXT;
import static woowa.lms.front.component.textfield.foolproof.FoolProofType.*;

public class SignUpForm implements CustomForm {

    private Scene scene;
    private VBox mainPane;
    private Background background;

    private Label headerLabel;
    private ImageView logoImageView;

    private GridPane form;
    private Label idLabel;
    private Label pwLabel;
    private Label confirmPwLabel;
    private Label nameLabel;
    private Label contactLabel;
    private InputField idInputField = InputField.of(TEXT, ID_FIELD);
    private InputField pwInputField = InputField.of(PASSWORD, PW_FIELD);
    private InputField confirmPwInputField = InputField.of(PASSWORD, CONFIRM_PW_FIELD);
    private InputField nameInputField = InputField.of(TEXT, NAME_FIELD);
    private InputField contactInputField = InputField.of(TEXT, CONTACT_FIELD);
    private TextField idField;
    private TextField pwField;
    private TextField confirmPwField;
    private TextField nameField;
    private TextField contactField;

    private HBox buttonBox;
    private Button okButton;
    private Button cancelButton;

    private double imageWidth;

    public static final SignUpForm INSTANCE = new SignUpForm();

    private SignUpForm() {
        mainPane = new VBox(0);
        scene = new Scene(mainPane, 400, 450);
        mainPane.setSpacing(scene.getHeight() * 0.15);

        form = new GridPane();

        buttonBox = new HBox(10);

        imageWidth = scene.getWidth() * 0.16;

        setUpComponents();
        setUpPage();
        setFoolProof();
    }

    @Override
    public void setUpComponents() {
        BackgroundBuilder customBackground = BackgroundBuilder.MAIN_BACKGROUND;
        background = customBackground.toBackground();

        FontBuilder customFont = FontBuilder.builder().font(HANNA_11).size(50).build();
        LabelBuilder customLabel = LabelBuilder.builder().text("Sign Up").font(customFont)
            .textFill("white").build();
        headerLabel = customLabel.toLabel();

        ImageBuilder customImage = ImageBuilder.builder().imageType(LOGO)
            .width(imageWidth).height(imageWidth).build();
        logoImageView = customImage.toImageView();

        customFont.setFont(EULJIRO);
        customFont.setSize(18);
        customLabel.setFont(customFont);
        customLabel.setText("Id");
        customLabel.setTextFill("black");
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

        customFont.setSize(10);
        customLabel.setFont(customFont);
        customLabel.setText("");
        customImage.setImageType(OK);
        customImage.setWidth(48);
        customImage.setHeight(48);
        List<TextField> fields =
            List.of(idField, pwField, confirmPwField, nameField, confirmPwField);
        GeneralButton button = GeneralButton.builder().label(customLabel)
            .image(customImage).display(GRAPHIC_ONLY).graphicGap(0)
            .behavior(BehaviorType.SIGN_IN).fields(fields).build();
        okButton = button.toButton();
        okButton.setDisable(true);

        customImage.setImageType(CANCEL);
        button.setBehavior(BehaviorType.CLOSE);
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
        form.setHgap(scene.getWidth() * 0.03);
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
        List<InputField> inputFields = List.of(idInputField, pwInputField,
            confirmPwInputField, nameInputField, contactInputField);
        SignUpFoolProof signUpFoolProof = SignUpFoolProof.builder()
            .button(okButton).inputFields(inputFields).build();
        idField.setOnKeyReleased(signUpFoolProof);
        pwField.setOnKeyReleased(signUpFoolProof);
        confirmPwField.setOnKeyReleased(signUpFoolProof);
        nameField.setOnKeyReleased(signUpFoolProof);
        contactField.setOnKeyReleased(signUpFoolProof);
    }

    @Override
    public Stage getStage() {
        Stage signUpStage = new Stage();
        signUpStage.setScene(scene);
        signUpStage.setTitle("Sign Up");
        return signUpStage;
    }
}
