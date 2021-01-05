package woowa.lms.front.component.button;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import lombok.Builder;
import lombok.Setter;
import woowa.lms.front.behavior.BehaviorType;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.image.ImageType;
import woowa.lms.front.component.label.LabelBuilder;

import static javafx.scene.control.ContentDisplay.BOTTOM;
import static javafx.scene.control.ContentDisplay.GRAPHIC_ONLY;

@Builder
@Setter
public class GeneralButton extends Button implements CustomButton {

    public static final GeneralButton DEFAULT_BUTTON = GeneralButton.builder().build();

    private static GeneralButton generalButton = GeneralButton.builder().build();

    @Builder.Default
    private Label label = LabelBuilder.DEFAULT_LABEL.toLabel();

    @Builder.Default
    private ImageView image = null;

    @Builder.Default
    private ContentDisplay display = ContentDisplay.BOTTOM;

    @Builder.Default
    private double graphicGap = 10;

    @Builder.Default
    private BehaviorType behavior = null;

    public static Button getMainButton(String text, ImageView image, BehaviorType behavior) {
        Label label = LabelBuilder.getButtonLabel(text);
        generalButton.setLabel(label);
        generalButton.setImage(image);
        generalButton.setDisplay(BOTTOM);
        generalButton.setGraphicGap(10);
        generalButton.setBehavior(behavior);
        return generalButton.toButton();
    }

    public static Button getFormButton(ImageBuilder image, BehaviorType behavior) {
        generalButton.setImage(image.toImageView());
        generalButton.setDisplay(GRAPHIC_ONLY);
        generalButton.setGraphicGap(0);
        generalButton.setBehavior(behavior);
        Button button = generalButton.toButton();
        button.setPadding(new Insets(4, 8, 4, 8));
        button.setFocusTraversable(false);
        return button;
    }

    public static Button getTableButton(ImageType image, BehaviorType behavior) {
        ImageView imageView = ImageBuilder.getTableButtonImage(image);
        generalButton.setImage(imageView);
        generalButton.setDisplay(GRAPHIC_ONLY);
        generalButton.setGraphicGap(0);
        generalButton.setBehavior(behavior);
        Button button = generalButton.toButton();
        button.setPadding(new Insets(4));
        return button;
    }

    @Override
    public Button toButton() {
        GeneralButton button = new GeneralButton(label, image, display, graphicGap, behavior);
        Label label = this.label;
        ImageView imageView = image;
        button.setText(label.getText());
        button.setFont(label.getFont());
        button.setTextFill(label.getTextFill());
        button.setGraphic(imageView);
        button.setContentDisplay(display);
        button.setGraphicTextGap(graphicGap);
        button.setOnAction(behavior.getBehavior());
        return button;
    }
}
