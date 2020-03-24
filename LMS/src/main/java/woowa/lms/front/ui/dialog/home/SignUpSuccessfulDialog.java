package woowa.lms.front.ui.dialog.home;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.ui.dialog.AbstractDialog;

import static woowa.lms.front.component.image.ImageType.SUCCESS;

public class SignUpSuccessfulDialog extends AbstractDialog {

    private static final Alert.AlertType ALERT_TYPE = Alert.AlertType.NONE;
    private static final String TITLE = "Sign Up Successful Dialog";
    private static final String HEADER_TEXT = "You are successfully signed up!";
    private static final String CONTENT_TEXT = "Welcome to Woowa library!";
    private static final SignUpSuccessfulDialog DIALOG =
        new SignUpSuccessfulDialog(ALERT_TYPE, TITLE, HEADER_TEXT, CONTENT_TEXT);

    private SignUpSuccessfulDialog(Alert.AlertType alertType, String title,
                                   String headerText, String contentText) {
        super(alertType, title, headerText, contentText);
        setUpComponents();
        setUpPage();
    }

    public static SignUpSuccessfulDialog getDialog() {
        return DIALOG;
    }

    @Override
    public void setUpComponents() {
        super.setUpComponents();

        ImageBuilder imageBuilder = ImageBuilder.builder().image(SUCCESS).build();
        headerImage = imageBuilder.toImageView();
    }

    @Override
    public void setUpPage() {
        super.setUpPage();

        dialogPane.getButtonTypes().addAll(ButtonType.OK);
    }
}
