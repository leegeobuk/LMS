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
    protected String header;
    protected String content;

    protected AbstractDialog(String title, String header, String content) {
        alert = new Alert(Alert.AlertType.NONE);
        dialogPane = new DialogPane();
        this.title = title;
        this.header = header;
        this.content = content;
    }

    @Override
    public void setUpComponents() {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();
        headerLabel = LabelBuilder.getDialogHeader(header);
        contentLabel = LabelBuilder.getDialogContent(content);
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
