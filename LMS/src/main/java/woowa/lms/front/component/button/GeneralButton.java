package woowa.lms.front.component.button;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import lombok.Builder;
import lombok.Setter;
import woowa.lms.front.behavior.BehaviorType;
import woowa.lms.front.component.image.CustomImage;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.LabelBuilder;

import static javafx.scene.control.ContentDisplay.GRAPHIC_ONLY;

@Builder
@Setter
public class GeneralButton extends Button implements CustomButton {

    public static final GeneralButton DEFAULT_BUTTON = GeneralButton.builder().build();

    private static GeneralButton generalButton = GeneralButton.builder().build();

    @Builder.Default
    private Label label = LabelBuilder.DEFAULT_LABEL;

    @Builder.Default
    private ImageView image = null;

    @Builder.Default
    private ContentDisplay display = ContentDisplay.BOTTOM;

    @Builder.Default
    private double graphicGap = 10;

    @Builder.Default
    private BehaviorType behavior = null;

    public static Button getFormButton(ImageView image, BehaviorType behavior) {
        generalButton.setDisplay(GRAPHIC_ONLY);
        generalButton.setGraphicGap(0);
        generalButton.setImage(image);
        generalButton.setBehavior(behavior);
        return generalButton.toButton();
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
        button.setOnMouseClicked(behavior.getBehavior());
        return button;
    }
}
