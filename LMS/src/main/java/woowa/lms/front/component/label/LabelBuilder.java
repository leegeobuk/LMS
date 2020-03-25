package woowa.lms.front.component.label;

import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import lombok.Builder;
import lombok.Setter;

import static woowa.lms.front.component.font.FontBuilder.*;

@Builder
@Setter
public class LabelBuilder implements CustomLabel {

    public static final Label DEFAULT_LABEL = LabelBuilder.builder().build().toLabel();

    private static LabelBuilder generalLabel = LabelBuilder.builder().build();

    @Builder.Default
    private String text = "";

    @Builder.Default
    private String textFill = "black";

    @Builder.Default
    private Font font = DEFAULT_FONT;

    public static Label getMainHeader(String text) {
        generalLabel.setText(text);
        generalLabel.setTextFill("white");
        generalLabel.setFont(MAIN_HEADER_FONT);
        return generalLabel.toLabel();
    }

    public static Label getButtonLabel(String text) {
        generalLabel.setText(text);
        generalLabel.setTextFill("#2ac1bc");
        generalLabel.setFont(BUTTON_FONT);
        return generalLabel.toLabel();
    }

    public static Label getPageHeader(String text) {
        generalLabel.setText(text);
        generalLabel.setTextFill("white");
        generalLabel.setFont(PAGE_HEADER_FONT);
        return generalLabel.toLabel();
    }

    public static Label getDialogHeader(String text) {
        Font dialogFont = getDialogFont(20);
        generalLabel.setFont(dialogFont);
        generalLabel.setText(text);
        return generalLabel.toLabel();
    }

    public static Label getDialogContent(String text) {
        Font dialogFont = getDialogFont(15);
        generalLabel.setFont(dialogFont);
        generalLabel.setText(text);
        return generalLabel.toLabel();
    }

    public static Label getFormLabel(String text) {
        generalLabel.setText(text);
        generalLabel.setFont(FORM_LABEL_FONT);
        return generalLabel.toLabel();
    }

    @Override
    public Label toLabel() {
        Label label = new Label(text);
        label.setTextFill(Paint.valueOf(textFill));
        label.setFont(font);
        return label;
    }
}
