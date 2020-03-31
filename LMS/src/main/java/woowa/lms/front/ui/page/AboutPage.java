package woowa.lms.front.ui.page;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.LabelBuilder;

import static woowa.lms.front.behavior.BehaviorType.CLOSE;
import static woowa.lms.front.behavior.BehaviorType.CLOSE_ABOUT;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_CANCEL;

public class AboutPage extends AbstractPage {

    private Text aboutText;
    private Button closeButton;

    private static final double WIDTH = 480;
    private static final double HEIGHT = 400;

    public static final AboutPage PAGE = new AboutPage(WIDTH, HEIGHT);

    private AboutPage(double width, double height) {
        super(width, height);
        mainBox = new VBox();
        String headerText = "About Page";
        setUpComponents(headerText);
        setUpPage();
        setUpStage(headerText);
    }

    @Override
    public void setUpComponents(String pageTitle) {
        super.setUpComponents(pageTitle);

        AboutPageText pageText = AboutPageText.getInstance();
        aboutText = pageText.toText();
        aboutText.setWrappingWidth(this.getWidth() - 30);
        aboutText.setTextAlignment(TextAlignment.JUSTIFY);

        closeButton = GeneralButton.getFormButton(FORM_BUTTON_CANCEL, CLOSE_ABOUT);
        closeButton.setCancelButton(true);
    }

    @Override
    public void setUpPage() {
        super.setUpPage();

        mainBox.getChildren().addAll(aboutText, closeButton);
        ((VBox) mainBox).setAlignment(Pos.CENTER_RIGHT);

        mainPane.setPadding(new Insets(20, 20, 60, 20));
        mainPane.setSpacing(this.getHeight() * 0.05);
    }

    @Override
    public void setUpStage(String title) {
        super.setUpStage(title);
        this.setResizable(false);
    }
}