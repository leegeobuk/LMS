package woowa.lms.front.ui.dialog.error;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.ui.dialog.AbstractDialog;

import static woowa.lms.front.component.image.ImageType.ERROR;

public class SignInErrorDialog extends AbstractDialog {

    private static final Alert.AlertType ALERT_TYPE = Alert.AlertType.NONE;
    private static final String TITLE = "Sign In Error Dialog";
    private static final String INVALID_ID_TEXT = "Sorry, ID doesn't exist!";
    private static final String INVALID_PW_TEXT = "Sorry, password is incorrect!";
    private static final String CONTENT_TEXT = "Please try again :(";
    private static final SignInErrorDialog DIALOG =
        new SignInErrorDialog(ALERT_TYPE, TITLE, INVALID_ID_TEXT, CONTENT_TEXT);

    private SignInErrorDialog(Alert.AlertType alertType, String title,
                              String headerText, String contentText) {
        super(alertType, title, headerText, contentText);
        setUpComponents();
        setUpPage();
    }

    public static SignInErrorDialog getDialog() {
        return DIALOG;
    }

    public void setErrorMessage(String message) {
        if (message.toLowerCase().contains("id")) {
            headerLabel.setText(INVALID_ID_TEXT);
        } else {
            headerLabel.setText(INVALID_PW_TEXT);
        }
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
