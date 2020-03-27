package woowa.lms.front.ui.page;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import woowa.lms.back.util.Token;
import woowa.lms.front.behavior.BehaviorType;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.image.ImageType;
import woowa.lms.front.component.label.LabelBuilder;

import static woowa.lms.front.behavior.BehaviorType.SIGN_OUT;
import static woowa.lms.front.behavior.BehaviorType.*;
import static woowa.lms.front.component.image.ImageType.*;

public class MainPage extends AbstractPage {

    private Button aboutButton;
    private Button signUpButton;
    private Button bookButton;
    private Button customerButton;
    private Button signInButton;
    private Button exitButton;

    private static final double WIDTH = 960;
    private static final double HEIGHT = 540;

    public static final MainPage PAGE = new MainPage(WIDTH, HEIGHT);

    private MainPage(double width, double height) {
        super(width, height);
        setUpComponents();
        setUpPage();
        setUpStage();
    }

    @Override
    public void setUpComponents() {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();

        headerLabel = LabelBuilder.getMainHeader("Woowa Library");

        logoImageView = ImageBuilder.getLogo(imageWidth);


        ImageView customImage = ImageBuilder.getImageView(ABOUT, imageWidth);
        aboutButton = GeneralButton.getMainButton("About", customImage, SHOW_ABOUT);

        customImage = ImageBuilder.getImageView(ImageType.SIGN_UP, imageWidth);
        signUpButton = GeneralButton.getMainButton("Sign Up", customImage, SHOW_SIGN_UP);

        customImage = ImageBuilder.getImageView(ImageType.SIGN_IN, imageWidth);
        signInButton = GeneralButton.getMainButton("Sign In", customImage, SHOW_SIGN_IN);

        customImage = ImageBuilder.getImageView(EXIT, imageWidth);
        exitButton = GeneralButton.getMainButton("Exit", customImage, EXIT_PROGRAM);
        exitButton.setCancelButton(true);
    }

    public void redraw() {
        redrawButtons();
        ObservableList<Node> buttonList = mainBox.getChildren();
        buttonList.clear();
        if (signedIn) {
            buttonList.addAll(aboutButton, bookButton, customerButton,
                signInButton, exitButton);
        } else {
            buttonList.addAll(aboutButton, signUpButton, signInButton, exitButton);
        }
    }

    private void redrawButtons() {
        signedIn = Token.getToken().isSignedIn();
        imageWidth = imageWidth * (signedIn ? (7 / 8.0) : (8.0 / 7));
        aboutButton = drawButton("About", ABOUT, SHOW_ABOUT);
        bookButton = drawButton("Books", BOOK, SHOW_BOOKS);
        customerButton = drawButton("Customers", CUSTOMER, SHOW_CUSTOMERS);
        signInButton = signedIn
            ? drawButton("Sign Out", ImageType.SIGN_OUT, SIGN_OUT)
            : drawButton("Sign In", ImageType.SIGN_IN, SHOW_SIGN_IN);
        exitButton = drawButton("Exit", EXIT, EXIT_PROGRAM);
    }

    private Button drawButton(String text, ImageType image, BehaviorType behavior) {
        ImageView imageView = ImageBuilder.getImageView(image, imageWidth);
        return GeneralButton.getMainButton(text, imageView, behavior);
    }

    @Override
    public void setUpPage() {
        headerLabel.setGraphic(logoImageView);
        headerLabel.setGraphicTextGap(this.getWidth() * 0.01);

        mainBox.getChildren().addAll(aboutButton, signUpButton, signInButton, exitButton);
        mainBox.setAlignment(Pos.CENTER);

        mainPane.setBackground(background);
        mainPane.getChildren().addAll(headerLabel, mainBox);
        mainPane.setPadding(new Insets(20));
        mainPane.setAlignment(Pos.TOP_CENTER);
    }

    @Override
    public void setUpStage() {
        super.setUpStage();
        this.setTitle("Woowa Library Management System");
    }
}
