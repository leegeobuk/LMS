package woowa.lms.front.components.label;

import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;
import woowa.lms.front.components.font.CustomFont;
import woowa.lms.front.components.font.FontBuilder;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
public class LabelBuilder implements CustomLabel {

    private static final String DEFAULT_TEXT = "Default text";
    private static final String DEFAULT_TEXT_FILL = "black";
    private static final FontBuilder DEFAULT_FONT = FontBuilder.DEFAULT_FONT;

    public static final LabelBuilder DEFAULT_LABEL = LabelBuilder.builder().build();

    @Builder.Default
    private String text = DEFAULT_TEXT;

    @Builder.Default
    private String textFill = DEFAULT_TEXT_FILL;

    @Builder.Default
    private CustomFont font = DEFAULT_FONT;

    @Override
    public Label toLabel() {
        Label label = new Label(text);
        label.setTextFill(Paint.valueOf(textFill));
        label.setFont(font.toFont());
        return label;
    }
}