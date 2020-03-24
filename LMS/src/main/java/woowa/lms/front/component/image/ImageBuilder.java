package woowa.lms.front.component.image;

import javafx.scene.image.ImageView;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import static woowa.lms.front.component.image.ImageType.CANCEL;
import static woowa.lms.front.component.image.ImageType.OK;

@Builder
@Getter @Setter
public class ImageBuilder implements CustomImage {

    public static final ImageBuilder DEFAULT_IMAGE = ImageBuilder.builder().build();
    public static final ImageBuilder FORM_BUTTON_OK =
        ImageBuilder.builder().image(OK).width(48).height(48).build();
    public static final ImageBuilder FORM_BUTTON_CANCEL =
        ImageBuilder.builder().image(CANCEL).width(48).height(48).build();

    public static ImageBuilder logo = ImageBuilder.builder().build();

    @Builder.Default
    private ImageType image = ImageType.LOGO;

    @Builder.Default
    private double width = 64;

    @Builder.Default
    private double height = 64;

    public static ImageView getLogo(double size) {
        logo.setHeight(size);
        logo.setWidth(size);
        return logo.toImageView();
    }

    @Override
    public ImageView toImageView() {
        ImageView imageView = image.getImageView();
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        return imageView;
    }
}
