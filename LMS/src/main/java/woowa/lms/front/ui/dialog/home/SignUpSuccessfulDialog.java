package woowa.lms.front.ui.dialog.home;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.ui.dialog.Showable;

import static woowa.lms.front.component.image.ImageType.EXIT_DIALOG;
import static woowa.lms.front.component.image.ImageType.SUCCESS;

public class SignUpSuccessfulDialog implements Showable {

    private Alert alert;
    private DialogPane dialogPane;
    private Background background;
    private Label headerLabel;
    private ImageView headerImage;
    private Label contentLabel;
    private String title;
    private String headerText;
    private String contentText;

    private static final SignUpSuccessfulDialog DIALOG = new SignUpSuccessfulDialog();

    public SignUpSuccessfulDialog() {
        alert = new Alert(Alert.AlertType.NONE);
        dialogPane = new DialogPane();
        title = "Sign Up Successful Dialog";
        headerText = "You are successfully signed up!";
        contentText = "Welcome to Woowa library!";
        setUpComponents();
        setUpPage();
    }

    public static SignUpSuccessfulDialog getDialog() {
        return DIALOG;
    }

    @Override
    public void setUpComponents() {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();

        headerLabel = LabelBuilder.getDialogHeader(headerText).toLabel();

        ImageBuilder imageBuilder = ImageBuilder.builder().imageType(SUCCESS).build();
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
