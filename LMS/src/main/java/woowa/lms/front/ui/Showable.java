package woowa.lms.front.ui;

import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import woowa.lms.front.ui.View;

public interface Showable extends View {

    void show();

    default void setUpHeader(Label headerLabel) {
        headerLabel.setPadding(new Insets(10));
        headerLabel.setContentDisplay(ContentDisplay.RIGHT);
        headerLabel.setGraphicTextGap(15);
    }

    default void setUpDialogPane(DialogPane dialogPane, Background background, Label headerLabel, Label contentLabel) {
        dialogPane.setBackground(background);
        dialogPane.setHeader(headerLabel);
        dialogPane.setContent(contentLabel);
    }
}
