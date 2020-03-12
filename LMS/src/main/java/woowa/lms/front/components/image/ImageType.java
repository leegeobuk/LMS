package woowa.lms.front.components.image;

import javafx.scene.image.ImageView;
import lombok.Setter;

public enum ImageType {
    LOGO("Logo.png"),
    ABOUT("icon/About.png"),
    SIGNUP("icon/SignUp.png"),
    SIGNIN("icon/SignIn.png"),
    EXIT("icon/Exit.png");

    private static final String URL = "file:src/main/resources/image/";

    private final String imageUrl;

    @Setter
    private double width;

    @Setter
    private double height;

    ImageType(String imageUrl) {
        this.imageUrl = URL + imageUrl;
    }

    public ImageView getImageView() {
        return new ImageView(this.imageUrl);
    }
}
