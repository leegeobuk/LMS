package woowa.lms.front.ui.dialog;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.label.LabelBuilder;

public abstract class AbstractDialog implements Showable {

    protected Alert alert;
    protected DialogPane dialogPane;
    protected Background background;
    protected Label headerLabel;
    protected ImageView headerImage;
    protected Label contentLabel;
    protected String title;
    protected String headerText;
    protected String contentText;

    protected AbstractDialog(Alert.AlertType alertType, String title, String headerText, String contentText) {
        alert = new Alert(alertType);
        dialogPane = new DialogPane();
        this.title = title;
        this.headerText = headerText;
        this.contentText = contentText;
    }

    @Override
    public void setUpComponents() {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();

        headerLabel = LabelBuilder.getDialogHeader(headerText);

        contentLabel = LabelBuilder.getDialogContent(contentText);
    }

    @Override
    public void setUpPage() {
        setUpHeader(headerLabel);
        headerLabel.setGraphic(headerImage);

        setUpDialogPane(dialogPane, background, headerLabel, contentLabel);

        alert.setDialogPane(dialogPane);
        alert.setTitle(title);
    }

    @Override
    public void show() {
        alert.showAndWait();
    }
}
