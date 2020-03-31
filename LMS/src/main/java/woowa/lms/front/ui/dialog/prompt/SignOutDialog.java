package woowa.lms.front.ui.dialog.prompt;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import woowa.lms.back.util.Token;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.controller.HomeController;
import woowa.lms.front.ui.dialog.AbstractDialog;

import java.util.Optional;

import static woowa.lms.front.component.image.ImageType.CONFIRM;

public class SignOutDialog extends AbstractDialog {

    private static final Alert.AlertType ALERT_TYPE = Alert.AlertType.NONE;
    private static final String TITLE = "Sign Out Dialog";
    private static final String HEADER_TEXT = "Are you sure you want to sign out?";
    private static final String CONTENT_TEXT = "Think twice!!";
    private static final SignOutDialog DIALOG =
        new SignOutDialog(ALERT_TYPE, TITLE, CONTENT_TEXT);

    private SignOutDialog(Alert.AlertType alertType, String title,
                          String contentText) {
        super(alertType, title, contentText);

        setUpComponents(HEADER_TEXT);
        setUpPage();
    }

    public static SignOutDialog getDialog() {
        return DIALOG;
    }

    @Override
    public void setUpComponents(String pageTitle) {
        super.setUpComponents(pageTitle);

        headerImage = ImageBuilder.getDialogImage(CONFIRM);
    }

    @Override
    public void show() {
        Optional<ButtonType> response = alert.showAndWait();
        if (response.isPresent() && response.get() == ButtonType.OK) {
            Token.getToken().signOut();
            HomeController.getController().redrawMainPage();
        }
    }
}
