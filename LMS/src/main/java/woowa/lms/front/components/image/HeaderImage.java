package woowa.lms.front.components.image;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HeaderImage extends CustomImage {

    private HeaderImage(String imageUrl, double width, double height) {
        super(imageUrl, width, height);
    }

    public static HeaderImage of(String imageUrl, double width, double height) {
        return new HeaderImage(imageUrl, width, height);
    }

    @Override
    public ImageView create() {
        image = new Image(url);
        iv = new ImageView(image);
        iv.setFitWidth(width);
        iv.setFitHeight(height);
        return iv;
    }
}
