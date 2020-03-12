package woowa.lms.front.components.image;

import javafx.scene.image.ImageView;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class ImageBuilder implements CustomImage {

    private static final ImageType DEFAULT_IMAGE_TYPE = ImageType.LOGO;
    private static final int DEFAULT_SIZE = 100;

    public static final ImageBuilder DEFAULT_IMAGE = ImageBuilder.builder().build();
    public static final ImageBuilder LOGO_IMAGE = DEFAULT_IMAGE;

    @Builder.Default
    private ImageType imageType = DEFAULT_IMAGE_TYPE;

    @Builder.Default
    private double width = DEFAULT_SIZE;

    @Builder.Default
    private double height = DEFAULT_SIZE;

    @Override
    public ImageView toImageView() {
        ImageView imageView = imageType.getImageView();
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        return imageView;
    }
}
