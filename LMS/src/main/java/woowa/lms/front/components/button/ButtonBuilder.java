package woowa.lms.front.components.button;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import lombok.Builder;
import lombok.Setter;
import woowa.lms.front.components.button.behavior.ClickBehavior;
import woowa.lms.front.components.button.behavior.ClickBehaviorType;
import woowa.lms.front.components.button.behavior.ClickExit;
import woowa.lms.front.components.image.CustomImage;
import woowa.lms.front.components.image.ImageBuilder;
import woowa.lms.front.components.label.CustomLabel;
import woowa.lms.front.components.label.LabelBuilder;

@Builder
@Setter
public class ButtonBuilder implements CustomButton {

    private static final CustomLabel DEFAULT_LABEL = LabelBuilder.DEFAULT_LABEL;
    private static final CustomImage DEFAULT_IMAGE = ImageBuilder.DEFAULT_IMAGE;
    private static final ClickBehavior DEFAULT_BEHAVIOR = ClickExit.getInstance();
    private static final ContentDisplay DEFAULT_DISPLAY = ContentDisplay.BOTTOM;
    private static final double DEFAULT_GRAPHIC_GAP = 4;

    public static final ButtonBuilder DEFAULT_BUTTON = ButtonBuilder.builder().build();

    @Builder.Default
    private CustomLabel label = DEFAULT_LABEL;

    @Builder.Default
    private CustomImage image = DEFAULT_IMAGE;

    @Builder.Default
    private ContentDisplay display = DEFAULT_DISPLAY;

    @Builder.Default
    private double graphicGap = DEFAULT_GRAPHIC_GAP;

    @Builder.Default
    private ClickBehavior clickBehavior = DEFAULT_BEHAVIOR;

    @Override
    public Button toButton() {
        Label label = this.label.toLabel();
        ImageView imageView = image.toImageView();
        Button button = new Button(label.getText());
        button.setFont(label.getFont());
        button.setTextFill(label.getTextFill());
        button.setGraphic(imageView);
        button.setContentDisplay(display);
        button.setGraphicTextGap(graphicGap);
        button.setOnMouseClicked(clickBehavior);
        return button;
    }
}
