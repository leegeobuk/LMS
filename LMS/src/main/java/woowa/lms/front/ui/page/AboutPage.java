package woowa.lms.front.ui.page;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.LabelBuilder;

import static woowa.lms.front.behavior.BehaviorType.CLOSE_ABOUT;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_CANCEL;

public class AboutPage extends AbstractPage {

    private Text aboutText;
    private HBox buttonBox;
    private Button closeButton;

    private static final double WIDTH = 480;
    private static final double HEIGHT = 400;

    public static final AboutPage PAGE = new AboutPage(WIDTH, HEIGHT);

    private AboutPage(double width, double height) {
        super(width, height);
        mainPane.setSpacing(height * 0.1);
        buttonBox = new HBox();
        setUpComponents();
        setUpPage();
        setUpStage();
    }

    @Override
    public void setUpComponents() {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();

        headerLabel = LabelBuilder.getPageHeader("About Page");

        logoImageView = ImageBuilder.getLogo(imageWidth);

        AboutPageText pageText = AboutPageText.getInstance();
        aboutText = pageText.toText();
        aboutText.setWrappingWidth(this.getWidth() - 30);
        aboutText.setTextAlignment(TextAlignment.JUSTIFY);

        closeButton = GeneralButton.getFormButton(FORM_BUTTON_CANCEL, CLOSE_ABOUT);
        closeButton.setCancelButton(true);
    }

    @Override
    public void setUpPage() {
        headerLabel.setGraphic(logoImageView);
        headerLabel.setGraphicTextGap(this.getWidth() * 0.05);

        mainBox.getChildren().addAll(aboutText);

        buttonBox.getChildren().addAll(closeButton);
        buttonBox.setPadding(new Insets(0, 0, 40, 0));
        buttonBox.setAlignment(Pos.TOP_RIGHT);

        mainPane.setBackground(background);
        mainPane.getChildren().addAll(headerLabel, mainBox, buttonBox);
        mainPane.setPadding(new Insets(20, 20, 60, 20));
        mainPane.setAlignment(Pos.TOP_CENTER);
        mainPane.setSpacing(this.getHeight() * 0.05);
    }

    @Override
    public void setUpStage() {
        super.setUpStage();
        this.setResizable(false);
        this.setTitle("About Page");
    }
}