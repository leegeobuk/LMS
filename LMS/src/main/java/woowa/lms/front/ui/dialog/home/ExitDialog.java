package woowa.lms.front.ui.dialog.home;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.ui.dialog.Showable;

import java.util.Optional;

import static woowa.lms.front.component.image.ImageType.EXIT_DIALOG;

public class ExitDialog implements Showable {

    private Alert alert;
    private DialogPane dialogPane;
    private Background background;
    private Label headerLabel;
    private ImageView headerImage;
    private Label contentLabel;
    private String title;
    private String headerText;
    private String contentText;

    private static final ExitDialog DIALOG = new ExitDialog();

    private ExitDialog() {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        dialogPane = new DialogPane();
        title = "Exit Dialog";
        headerText = "Application terminates when pressed OK!";
        contentText = "Think twice!!";
        setUpComponents();
        setUpPage();
    }

    public static ExitDialog getDialog() {
        return DIALOG;
    }

    @Override
    public void setUpComponents() {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();

        headerLabel = LabelBuilder.getDialogHeader(headerText).toLabel();

        ImageBuilder imageBuilder = ImageBuilder.builder().imageType(EXIT_DIALOG).build();
        headerImage = imageBuilder.toImageView();

        contentLabel = LabelBuilder.getDialogContent(contentText).toLabel();
    }

    @Override
    public void setUpPage() {
        setUpHeader(headerLabel);
        headerLabel.setGraphic(headerImage);

        setUpDialogPane(dialogPane, background, headerLabel, contentLabel);
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        alert.setDialogPane(dialogPane);
        alert.setTitle(title);
    }

    @Override
    public void show() {
        Optional<ButtonType> response = alert.showAndWait();
        if (response.isPresent() && response.get() == ButtonType.OK) {
            Platform.exit();
        }
    }
}
