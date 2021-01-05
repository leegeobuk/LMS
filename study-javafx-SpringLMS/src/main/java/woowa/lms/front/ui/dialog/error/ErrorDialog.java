package woowa.lms.front.ui.dialog.error;

import javafx.scene.control.ButtonType;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.ui.dialog.AbstractDialog;

import static woowa.lms.front.component.image.ImageType.ERROR;

public class ErrorDialog extends AbstractDialog {

    private static final String TITLE = "Error Dialog";
    private static final String HEADER = "Exception occurred!";
    private static final String CONTENT = "Please try again :(";
    private static ErrorDialog dialog = new ErrorDialog(TITLE, HEADER, CONTENT);

    private ErrorDialog(String title, String header, String content) {
        super(title, header, content);
        setUpComponents();
        setUpPage();
    }

    public static ErrorDialog getErrorDialog(String title, String header, String content) {
        dialog.alert.setTitle(title);
        dialog.headerLabel.setText(header);
        dialog.contentLabel.setText(content);
        return dialog;
    }

    @Override
    public void setUpComponents() {
        headerImage = ImageBuilder.getDialogImage(ERROR);
        super.setUpComponents();
    }

    @Override
    public void setUpPage() {
        dialogPane.getButtonTypes().setAll(ButtonType.OK, ButtonType.CANCEL);
        super.setUpPage();
    }
}
