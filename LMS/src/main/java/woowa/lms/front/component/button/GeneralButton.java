package woowa.lms.front.component.button;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import woowa.lms.front.component.button.behavior.BehaviorType;
import woowa.lms.front.component.image.CustomImage;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.CustomLabel;
import woowa.lms.front.component.label.LabelBuilder;

import java.util.List;

@Builder
@Getter @Setter
public class GeneralButton extends Button implements CustomButton {

    private static final CustomLabel DEFAULT_LABEL = LabelBuilder.DEFAULT_LABEL;
    private static final CustomImage DEFAULT_IMAGE = ImageBuilder.DEFAULT_IMAGE;
    private static final BehaviorType DEFAULT_BEHAVIOR = null;
    private static final ContentDisplay DEFAULT_DISPLAY = ContentDisplay.BOTTOM;
    private static final double DEFAULT_GRAPHIC_GAP = 10;

    public static final GeneralButton DEFAULT_BUTTON = GeneralButton.builder().build();

    @Builder.Default
    protected CustomLabel label = DEFAULT_LABEL;

    @Builder.Default
    protected CustomImage image = DEFAULT_IMAGE;

    @Builder.Default
    protected ContentDisplay display = DEFAULT_DISPLAY;

    @Builder.Default
    protected double graphicGap = DEFAULT_GRAPHIC_GAP;

    @Builder.Default
    protected BehaviorType behavior = DEFAULT_BEHAVIOR;

    @Singular
    private List<TextField> fields;

    @Override
    public Button toButton() {
        GeneralButton button = new GeneralButton(label, image, display, graphicGap, behavior, fields);
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
