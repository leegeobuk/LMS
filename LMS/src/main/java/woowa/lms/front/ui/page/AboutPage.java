package woowa.lms.front.ui.page;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.LabelBuilder;

public class AboutPage extends AbstractPage {

    private Text aboutText;

    private static final double WIDTH = 480;
    private static final double HEIGHT = 360;

    public static final AboutPage PAGE = new AboutPage(WIDTH, HEIGHT);

    private AboutPage(double width, double height) {
        super(width, height);
        mainPane.setSpacing(height * 0.1);
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
        aboutText.setWrappingWidth(this.getWidth() - 20);
        aboutText.setTextAlignment(TextAlignment.JUSTIFY);
    }

    @Override
    public void setUpPage() {
        headerLabel.setGraphic(logoImageView);
        headerLabel.setGraphicTextGap(this.getWidth() * 0.05);

        mainBox.getChildren().addAll(aboutText);

        mainPane.setBackground(background);
        mainPane.getChildren().addAll(headerLabel, mainBox);
        mainPane.setPadding(new Insets(20));
        mainPane.setAlignment(Pos.TOP_CENTER);
    }

    @Override
    public void setUpStage() {
        super.setUpStage();
        this.setResizable(false);
        this.setTitle("About Page");
    }
}