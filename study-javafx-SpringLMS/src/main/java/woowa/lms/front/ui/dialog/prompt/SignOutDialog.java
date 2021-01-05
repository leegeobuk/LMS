package woowa.lms.front.ui.dialog.prompt;

import javafx.scene.control.ButtonType;
import woowa.lms.back.util.Token;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.controller.MainController;
import woowa.lms.front.ui.dialog.AbstractDialog;

import java.util.Optional;

import static woowa.lms.front.component.image.ImageType.CONFIRM;

public class SignOutDialog extends AbstractDialog {

    private static final String TITLE = "Sign Out Dialog";
    private static final String HEADER = "Are you sure you want to sign out?";
    private static final String CONTENT = "Think twice!!";
    private static final SignOutDialog DIALOG = new SignOutDialog();

    private SignOutDialog() {
        super(TITLE, HEADER, CONTENT);

        setUpComponents();
        setUpPage();
    }

    public static SignOutDialog getDialog() {
        return DIALOG;
    }

    @Override
    public void setUpComponents() {
        headerImage = ImageBuilder.getDialogImage(CONFIRM);
        super.setUpComponents();
    }

    @Override
    public void setUpPage() {
        dialogPane.getButtonTypes().setAll(ButtonType.OK, ButtonType.CANCEL);
        super.setUpPage();
    }

    @Override
    public void show() {
        Optional<ButtonType> response = alert.showAndWait();
        if (response.isPresent() && response.get() == ButtonType.OK) {
            Token.getToken().signOut();
            MainController.getController().redrawMainPage();
        }
    }
}
