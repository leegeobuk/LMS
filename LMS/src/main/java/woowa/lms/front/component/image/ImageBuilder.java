package woowa.lms.front.component.image;

import javafx.scene.image.ImageView;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import static woowa.lms.front.component.image.ImageType.*;

@Builder
@Getter @Setter
public class ImageBuilder implements CustomImage {

    public static final ImageView DEFAULT_IMAGE = ImageBuilder.builder().build().toImageView();
    public static final ImageView ERROR_DIALOG = ImageBuilder.builder().image(ERROR).build().toImageView();

    public static final ImageView FORM_BUTTON_OK =
        ImageBuilder.builder().image(OK).width(48).height(48).build().toImageView();

    public static final ImageView FORM_BUTTON_CANCEL =
        ImageBuilder.builder().image(CANCEL).width(48).height(48).build().toImageView();

    private static ImageBuilder generalImage = ImageBuilder.builder().build();

    @Builder.Default
    private ImageType image = ImageType.LOGO;

    @Builder.Default
    private double width = 64;

    @Builder.Default
    private double height = 64;

    public static ImageView getImageView(ImageType image, double size) {
        generalImage.setImage(image);
        generalImage.setWidth(size);
        generalImage.setHeight(size);
        return generalImage.toImageView();
    }

    public static ImageView getLogo(double size) {
        generalImage.setImage(LOGO);
        generalImage.setWidth(size);
        generalImage.setHeight(size);
        return generalImage.toImageView();
    }

    @Override
    public ImageView toImageView() {
        ImageView imageView = image.getImageView();
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        return imageView;
    }
}
