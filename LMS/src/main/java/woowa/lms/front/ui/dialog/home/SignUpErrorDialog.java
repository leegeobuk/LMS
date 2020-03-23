package woowa.lms.front.ui.dialog.home;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.ui.dialog.Showable;

import static woowa.lms.front.component.image.ImageType.ERROR;

public class SignUpErrorDialog implements Showable {

    private Alert alert;
    private DialogPane dialogPane;
    private Background background;
    private Label headerLabel;
    private ImageView headerImage;
    private Label contentLabel;
    private String title;
    private String headerText;
    private String contentText;

    private static final SignUpErrorDialog DIALOG = new SignUpErrorDialog();

    private SignUpErrorDialog() {
        alert = new Alert(Alert.AlertType.ERROR);
        dialogPane = new DialogPane();
        title = "Sign Up Error Dialog";
        headerText = "Sorry, ID already exists!";
        contentText = "Please try again :(";
        setUpComponents();
        setUpPage();
    }

    public static SignUpErrorDialog getDialog() {
        return DIALOG;
    }

    @Override
    public void setUpComponents() {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();

        headerLabel = LabelBuilder.getDialogHeader(headerText).toLabel();

        ImageBuilder imageBuilder = ImageBuilder.builder().imageType(ERROR).build();
        headerImage = imageBuilder.toImageView();

        contentLabel = LabelBuilder.getDialogContent(contentText).toLabel();
    }

    @Override
    public void setUpPage() {
        setUpHeader(headerLabel);
        headerLabel.setGraphic(headerImage);

        setUpDialogPane(dialogPane, background, headerLabel, contentLabel);
        dialogPane.getButtonTypes().addAll(ButtonType.OK);

        alert.setDialogPane(dialogPane);
        alert.setTitle(title);
    }

    @Override
    public void show() {
        alert.showAndWait();
    }
}
