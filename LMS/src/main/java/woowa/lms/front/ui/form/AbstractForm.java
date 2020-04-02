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
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.foolproof.FormFoolProof;
import woowa.lms.front.ui.FoolProofable;
import woowa.lms.front.ui.page.Page;

import java.util.List;
import java.util.stream.Collectors;

import static woowa.lms.front.component.image.ImageBuilder.getLogo;

public abstract class AbstractForm extends Stage implements Page, FoolProofable {

    protected VBox mainPane;
    protected Background background;

    protected Label headerLabel;
    protected ImageView logoImageView;

    protected GridPane form;
    protected List<InputField> inputFields;
    protected Label errorLabel;

    protected FormFoolProof formFoolProof;

    protected HBox buttonBox;
    protected Button okButton;
    protected Button cancelButton;

    protected double imageWidth;

    protected AbstractForm(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        mainPane = new VBox();
        mainPane.setSpacing(height * 0.05);

        form = new GridPane();
        errorLabel = new Label();

        buttonBox = new HBox(10);

        imageWidth = width * 0.16;
    }

    public void clear() {
        inputFields.forEach(InputField::clear);
        errorLabel.setText("");
        okButton.setDisable(true);
    }

    public List<TextField> getFields() {
        return inputFields.stream().map(InputField::getTextField)
            .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void setUpComponents(String pageTitle) {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();
        headerLabel = LabelBuilder.getPageHeader(pageTitle);
        logoImageView = getLogo(imageWidth);

        errorLabel = LabelBuilder.builder().textFill("red").build().toLabel();
        errorLabel.setWrapText(true);

        okButton.setDefaultButton(true);
        okButton.setDisable(true);

        cancelButton.setCancelButton(true);
    }

    @Override
    public void setUpPage() {
        headerLabel.setGraphic(logoImageView);
        headerLabel.setGraphicTextGap(this.getWidth() * 0.05);

        buttonBox.getChildren().addAll(okButton, cancelButton);
        buttonBox.setAlignment(Pos.CENTER);

        mainPane.setBackground(background);
        mainPane.getChildren().addAll(headerLabel, form, buttonBox);
        mainPane.setPadding(new Insets(20));
        mainPane.setAlignment(Pos.TOP_CENTER);
    }

    @Override
    public void setFoolProof() {
        formFoolProof = FormFoolProof.builder().button(okButton)
            .errorLabel(errorLabel).inputFields(inputFields).build();
        inputFields.forEach(inputField -> inputField.setOnKeyReleased(formFoolProof));
    }

    @Override
    public void setUpStage(String title) {
        Scene scene = new Scene(mainPane);
        this.setScene(scene);
        this.setTitle(title);
        this.setResizable(false);
    }
}
