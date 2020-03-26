package woowa.lms.front.ui.dialog.home;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.ui.dialog.AbstractDialog;

import static woowa.lms.front.component.image.ImageType.ERROR;

public class SignUpErrorDialog extends AbstractDialog {

    private static final Alert.AlertType ALERT_TYPE = Alert.AlertType.NONE;
    private static final String TITLE = "Sign Up Error Dialog";
    private static final String HEADER_TEXT = "Sorry, ID already exists!";
    private static final String CONTENT_TEXT = "Please try again :(";
    private static final SignUpErrorDialog DIALOG =
        new SignUpErrorDialog(ALERT_TYPE, TITLE, HEADER_TEXT, CONTENT_TEXT);

    private SignUpErrorDialog(Alert.AlertType alertType, String title,
                             String headerText, String contentText) {
        super(alertType, title, headerText, contentText);
        setUpComponents();
        setUpPage();
    }

    public static SignUpErrorDialog getDialog() {
        return DIALOG;
    }

    @Override
    public void setUpComponents() {
        super.setUpComponents();

        headerImage = ImageBuilder.getDialogImage(ERROR);
    }

    @Override
    public void setUpPage() {
        super.setUpPage();

        dialogPane.getButtonTypes().addAll(ButtonType.OK);
    }
}
