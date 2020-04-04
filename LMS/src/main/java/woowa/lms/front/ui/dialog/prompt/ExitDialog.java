package woowa.lms.front.ui.dialog.prompt;

import javafx.application.Platform;
import javafx.scene.control.ButtonType;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.ui.dialog.AbstractDialog;

import java.util.Optional;

import static woowa.lms.front.component.image.ImageType.WARNING;

public class ExitDialog extends AbstractDialog {

    private static final String TITLE = "Exit Dialog";
    private static final String HEADER = "Application terminates when pressed OK!";
    private static final String CONTENT = "Think twice!!";
    private static final ExitDialog DIALOG = new ExitDialog();

    private ExitDialog() {
        super(TITLE, HEADER, CONTENT);
        setUpComponents();
        setUpPage();
    }

    public static ExitDialog getDialog() {
        return DIALOG;
    }

    @Override
    public void setUpComponents() {
        headerImage = ImageBuilder.getDialogImage(WARNING);
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
            Platform.exit();
        }
    }
}
