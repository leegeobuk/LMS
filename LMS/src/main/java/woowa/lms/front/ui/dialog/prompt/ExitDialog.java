package woowa.lms.front.ui.dialog.prompt;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.ui.dialog.AbstractDialog;

import java.util.Optional;

import static woowa.lms.front.component.image.ImageType.WARNING;

public class ExitDialog extends AbstractDialog {

    private static final Alert.AlertType ALERT_TYPE = Alert.AlertType.NONE;
    private static final String TITLE = "Exit Dialog";
    private static final String HEADER_TEXT = "Application terminates when pressed OK!";
    private static final String CONTENT_TEXT = "Think twice!!";
    private static final ExitDialog DIALOG =
        new ExitDialog(ALERT_TYPE, TITLE, HEADER_TEXT, CONTENT_TEXT);

    private ExitDialog(Alert.AlertType alertType, String title,
                      String headerText, String contentText) {
        super(alertType, title, headerText, contentText);
        setUpComponents();
        setUpPage();
    }

    public static ExitDialog getDialog() {
        return DIALOG;
    }

    @Override
    public void setUpComponents() {
        super.setUpComponents();

        headerImage = ImageBuilder.getDialogImage(WARNING);
    }

    @Override
    public void setUpPage() {
        super.setUpPage();

        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
    }

    @Override
    public void show() {
        Optional<ButtonType> response = alert.showAndWait();
        if (response.isPresent() && response.get() == ButtonType.OK) {
            Platform.exit();
        }
    }
}
