package woowa.lms.front.ui.dialog.success;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.ui.dialog.AbstractDialog;

import static woowa.lms.front.component.image.ImageType.SUCCESS;

public class SignUpSuccessfulDialog extends AbstractDialog {

    private static final Alert.AlertType ALERT_TYPE = Alert.AlertType.NONE;
    private static final String TITLE = "Sign Up Successful Dialog";
    private static final String HEADER_TEXT = "You are successfully signed up!";
    private static final String CONTENT_TEXT = "Welcome to Woowa library!";
    private static final SignUpSuccessfulDialog DIALOG =
        new SignUpSuccessfulDialog(ALERT_TYPE, TITLE, CONTENT_TEXT);

    private SignUpSuccessfulDialog(Alert.AlertType alertType, String title,
                                   String contentText) {
        super(alertType, title, contentText);
        setUpComponents(HEADER_TEXT);
        setUpPage();
    }

    public static SignUpSuccessfulDialog getDialog() {
        return DIALOG;
    }

    @Override
    public void setUpComponents(String pageTitle) {
        super.setUpComponents(pageTitle);

        headerImage = ImageBuilder.getDialogImage(SUCCESS);
    }

    @Override
    public void setUpPage() {
        super.setUpPage();

        dialogPane.getButtonTypes().clear();
        dialogPane.getButtonTypes().addAll(ButtonType.OK);
    }
}
