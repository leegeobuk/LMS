package woowa.lms.front.ui.dialog;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.ui.Showable;

public abstract class AbstractDialog implements Showable {

    protected Alert alert;
    protected DialogPane dialogPane;
    protected Background background;
    protected Label headerLabel;
    protected ImageView headerImage;
    protected Label contentLabel;
    protected String title;
    protected String contentText;

    protected AbstractDialog(Alert.AlertType alertType, String title, String contentText) {
        alert = new Alert(alertType);
        dialogPane = new DialogPane();
        this.title = title;
        this.contentText = contentText;
    }

    @Override
    public void setUpComponents(String pageTitle) {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();
        headerLabel = LabelBuilder.getDialogHeader(pageTitle);
        contentLabel = LabelBuilder.getDialogContent(contentText);
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
        alert.showAndWait();
    }
}
