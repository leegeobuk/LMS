package woowa.lms.front.ui.page;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import woowa.lms.front.component.button.GeneralButton;

import static woowa.lms.front.behavior.BehaviorType.CLOSE;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_CANCEL;

public class AboutPage extends AbstractPage {

    private Text aboutText;
    private Button closeButton;

    private static final double WIDTH = 500;
    private static final double HEIGHT = 395;
    private static final String TITLE = "About Page";

    public static final AboutPage PAGE = new AboutPage();

    private AboutPage() {
        super(WIDTH, HEIGHT, TITLE, TITLE);
        mainBox = new VBox();
        setUpComponents();
        setUpPage();
        setUpStage();
    }

    @Override
    public void setUpComponents() {
        AboutPageText pageText = AboutPageText.getInstance();
        aboutText = pageText.toText();
        aboutText.setWrappingWidth(this.getWidth() - 40);
        aboutText.setTextAlignment(TextAlignment.JUSTIFY);

        closeButton = GeneralButton.getFormButton(FORM_BUTTON_CANCEL, CLOSE);
        closeButton.setCancelButton(true);
        super.setUpComponents();
    }

    @Override
    public void setUpPage() {
        mainBox.getChildren().addAll(aboutText, closeButton);
        ((VBox) mainBox).setAlignment(Pos.CENTER_RIGHT);

        mainPane.setSpacing(this.getHeight() * 0.05);
        super.setUpPage();
    }

    @Override
    public void setUpStage() {
        super.setUpStage();
        this.setResizable(false);
    }
}