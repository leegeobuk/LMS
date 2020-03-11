package woowa.lms.front.page;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import woowa.lms.front.components.background.MainBackground;
import woowa.lms.front.components.button.*;
import woowa.lms.front.components.font.EuljiroFont;
import woowa.lms.front.components.image.Image;
import woowa.lms.front.components.label.CustomLabel;

@Component
public class MainPage implements Page {

    private Stage primaryStage;
    private Scene scene;
    private VBox mainPane;
    private Background background;
    private VBox labelBox;
    private Image mainLogo;
    private Label mainLabel;
    private HBox buttonBox;
    private CustomButton aboutButton;
    private CustomButton signUpButton;
    private CustomButton signInButton;
    private CustomButton exitButton;
    private Label buttonLabel;
    private Image aboutIcon;
    private Image signUpIcon;
    private Image signInIcon;
    private Image exitIcon;
    private Font buttonFont = EuljiroFont.of(30);

    private static final String LOGO_URL = "file:src/main/resources/image/Logo.png";
    private static final String ABOUT_URL = "file:src/main/resources/image/icons/About.png";
    private static final String SIGN_UP_URL = "file:src/main/resources/image/icons/SignUp.png";
    private static final String SIGN_IN_URL = "file:src/main/resources/image/icons/SignIn.png";
    private static final String EXIT_URL = "file:src/main/resources/image/icons/Exit.png";

    public MainPage(Stage primaryStage, double width, double height) {
        this.primaryStage = primaryStage;
        mainPane = new VBox();
        background = MainBackground.getInstance();
        labelBox = new VBox();
        mainLabel = CustomLabel.builder().text("Woowa Library").font(EuljiroFont.of(100)).textFill("white").build().toLabel();
        buttonBox = new HBox(30);
        buttonLabel = CustomLabel.builder().font(buttonFont).textFill("#2ac1bc").build().toLabel();
        aboutButton = AboutButton.of(buttonLabel);
        signUpButton = SignUpButton.of(buttonLabel);
        signInButton = SignInButton.of(buttonLabel);
        exitButton = ExitButton.of(buttonLabel);
        scene = new Scene(mainPane, width, height);
        double sceneWidth = scene.getWidth();
        double sceneHeight = scene.getHeight();
        mainLogo = Image.builder().imageUrl(LOGO_URL).width(sceneWidth * 0.16).height(sceneHeight * 0.3).build();

        aboutIcon = Image.builder().imageUrl(ABOUT_URL).width(sceneWidth / 7).height(sceneHeight / 4).build();
        signUpIcon = Image.builder().imageUrl(SIGN_UP_URL).width(sceneWidth / 7).height(sceneHeight / 4).build();
        signInIcon = Image.builder().imageUrl(SIGN_IN_URL).width(sceneWidth / 7).height(sceneHeight / 4).build();
        exitIcon = Image.builder().imageUrl(EXIT_URL).width(sceneWidth / 7).height(sceneHeight / 4).build();
    }

    @Override
    public void setUpPage() {
        mainLabel.setGraphic(mainLogo.toImageView());
        mainLabel.setGraphicTextGap(30);
        labelBox.getChildren().addAll(mainLabel);
        labelBox.setAlignment(Pos.CENTER);
        labelBox.setPadding(new Insets(20, 0, 0, 0));

        buttonBox.getChildren().addAll(aboutButton, signUpButton, signInButton, exitButton);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonBox.setPadding(new Insets(40));

        mainPane.setBackground(background);
        mainPane.getChildren().addAll(labelBox, buttonBox);
    }

    @Override
    public void setUpButtons() {
        aboutButton.setGraphic(aboutIcon.toImageView());
        aboutButton.setGraphicTextGap(10);
        aboutButton.setContentDisplay(ContentDisplay.BOTTOM);

        signUpButton.setGraphic(signUpIcon.toImageView());
        signUpButton.setGraphicTextGap(10);
        signUpButton.setContentDisplay(ContentDisplay.BOTTOM);

        signInButton.setGraphic(signInIcon.toImageView());
        signInButton.setGraphicTextGap(10);
        signInButton.setContentDisplay(ContentDisplay.BOTTOM);

        exitButton.setGraphic(exitIcon.toImageView());
        exitButton.setGraphicTextGap(10);
        exitButton.setContentDisplay(ContentDisplay.BOTTOM);

        aboutButton.clicked();
        signUpButton.clicked();
        signInButton.clicked();
        exitButton.clicked();
    }

    @Override
    public void show() {
        setUpPage();
        setUpButtons();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Woowa Library Management System");
        primaryStage.show();
    }

}
