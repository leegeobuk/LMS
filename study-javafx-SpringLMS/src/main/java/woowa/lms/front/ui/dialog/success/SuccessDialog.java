package woowa.lms.front.ui.dialog.success;

import javafx.scene.control.ButtonType;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.ui.dialog.AbstractDialog;

import static woowa.lms.front.component.image.ImageType.SUCCESS;

public class SuccessDialog extends AbstractDialog {

    private static final String TITLE = "Success Dialog";
    private static final String HEADER = "You are successful!";
    private static final String CONTENT = "Congrats!";
    private static SuccessDialog dialog = new SuccessDialog(TITLE, HEADER, CONTENT);

    private SuccessDialog(String title, String header, String content) {
        super(title, header, content);
        setUpComponents();
        setUpPage();
    }

    public static SuccessDialog getSuccessDialog(String title, String header, String content) {
        dialog.alert.setTitle(title);
        dialog.headerLabel.setText(header);
        dialog.contentLabel.setText(content);
        return dialog;
    }

    @Override
    public void setUpComponents() {
        headerImage = ImageBuilder.getDialogImage(SUCCESS);
        super.setUpComponents();
    }

    @Override
    public void setUpPage() {
        dialogPane.getButtonTypes().setAll(ButtonType.OK);
        super.setUpPage();
    }
}
