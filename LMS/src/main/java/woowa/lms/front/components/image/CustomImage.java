package woowa.lms.front.components.image;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class CustomImage {

    ImageView iv;
    Image image;
    String url;
    double width;
    double height;

    CustomImage(String url, double width, double height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public abstract ImageView create();
}
