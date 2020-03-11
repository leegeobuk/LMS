package woowa.lms.front.components.image;

import javafx.scene.image.ImageView;
import lombok.Builder;
import lombok.NonNull;

@Builder
@NonNull
public class Image implements CustomImage {

   private String imageUrl;
   private double width;
   private double height;

    private Image(String imageUrl, double width, double height) {
        this.imageUrl = imageUrl;
        this.width = width;
        this.height = height;
    }

    public static Image of(String imageUrl, double width, double height) {
        return new Image(imageUrl, width, height);
    }

    @Override
    public ImageView toImageView() {
        ImageView iv = new ImageView(imageUrl);
        iv.setFitWidth(width);
        iv.setFitHeight(height);
        return iv;
    }
}
