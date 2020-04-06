package woowa.lms.front.component.image;

import javafx.scene.image.ImageView;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import static woowa.lms.front.component.image.ImageType.*;

@Builder
@Getter @Setter
public class ImageBuilder implements CustomImage {

    public static final ImageBuilder DEFAULT_IMAGE = ImageBuilder.builder().build();
    public static final ImageBuilder ERROR_DIALOG = ImageBuilder.builder().image(ERROR).build();

    public static final ImageBuilder FORM_BUTTON_OK =
        ImageBuilder.builder().image(OK).width(48).height(48).build();

    public static final ImageBuilder FORM_BUTTON_CANCEL =
        ImageBuilder.builder().image(CANCEL).width(48).height(48).build();

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

    public static ImageView getDialogImage(ImageType image) {
        generalImage.setImage(image);
        generalImage.setWidth(64);
        generalImage.setHeight(64);
        return generalImage.toImageView();
    }

    public static ImageView getTableButtonImage(ImageType image) {
        generalImage.setImage(image);
        generalImage.setWidth(48);
        generalImage.setHeight(48);
        return generalImage.toImageView();
    }

    @Override
    public ImageView toImageView() {
        ImageView imageView = new ImageView(image.getImageUrl());
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        return imageView;
    }
}
