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
import woowa.lms.front.component.label.CustomLabel;
import woowa.lms.front.component.label.LabelBuilder;

import static javafx.scene.control.ContentDisplay.GRAPHIC_ONLY;

@Builder
@Setter
public class GeneralButton extends Button implements CustomButton {

    public static final GeneralButton DEFAULT_BUTTON = GeneralButton.builder().build();

    private static GeneralButton formButton = GeneralButton.builder()
        .display(GRAPHIC_ONLY).graphicGap(0).build();

    @Builder.Default
    protected CustomLabel label = LabelBuilder.DEFAULT_LABEL;

    @Builder.Default
    protected CustomImage image = null;

    @Builder.Default
    protected ContentDisplay display = ContentDisplay.BOTTOM;

    @Builder.Default
    protected double graphicGap = 10;

    @Builder.Default
    protected BehaviorType behavior = null;

    public static Button getFormButton(ImageBuilder image, BehaviorType behavior) {
        formButton.setImage(image);
        formButton.setBehavior(behavior);
        return formButton.toButton();
    }

    @Override
    public Button toButton() {
        GeneralButton button = new GeneralButton(label, image, display, graphicGap, behavior);
        Label label = this.label.toLabel();
        ImageView imageView = image.toImageView();
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
