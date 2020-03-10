package woowa.lms.front.page.main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import woowa.lms.front.components.background.MainBackground;
import woowa.lms.front.components.button.CustomButton;
import woowa.lms.front.components.button.SignInButton;
import woowa.lms.front.components.button.SignUpButton;
import woowa.lms.front.components.font.EuljiroFont;
import woowa.lms.front.components.image.HeaderImage;
import woowa.lms.front.components.label.MainLabel;

public class MainPage {

    private Stage primaryStage;
    private Scene scene;
    private VBox mainPane;
    private Background background;
    private VBox labelBox;
    private ImageView mainLogo;
    private Label mainLabel;
    private HBox buttonBox;
    private CustomButton signUpButton;
    private CustomButton signInButton;

    private static final String URL = "file:src/main/resources/image/banner.png";
    private double imageWidth;
    private double imageHeight;

    public MainPage(Stage primaryStage, double width, double height) {
        this.primaryStage = primaryStage;
        mainPane = new VBox();
        background = MainBackground.of().create();
        labelBox = new VBox();
        mainLabel = MainLabel.of("Woowa Library", Color.WHITE, 100).create();
        buttonBox = new HBox(10);
        signUpButton = SignUpButton.of("Sign Up");
        signInButton = SignInButton.of("Sign In");
        scene = new Scene(mainPane, width, height);
        imageWidth = scene.getWidth() * 0.16;
        imageHeight = scene.getHeight() * 0.3;
        mainLogo = HeaderImage.of(URL, imageWidth, imageHeight).create();
    }

    public void setUp() {
        buttonBox.getChildren().addAll(signUpButton, signInButton);
        buttonBox.setAlignment(Pos.TOP_RIGHT);
        buttonBox.setPadding(new Insets(5));

        mainLabel.setGraphic(mainLogo);
        mainLabel.setGraphicTextGap(30);
        labelBox.getChildren().addAll(buttonBox, mainLabel);
        labelBox.setAlignment(Pos.CENTER);

        mainPane.setBackground(background);
        mainPane.getChildren().add(labelBox);
    }

    public void show() {
        setUp();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Welcome!");
        primaryStage.show();
    }

}
