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

    public static final LabelBuilder DEFAULT_LABEL = LabelBuilder.builder().build();

    private static LabelBuilder generalLabel = LabelBuilder.builder().build();

    @Builder.Default
    private String text = "";

    @Builder.Default
    private String textFill = "black";

    @Builder.Default
    private Font font = DEFAULT_FONT.toFont();

    public static Label getMainHeader(String text) {
        generalLabel.setText(text);
        generalLabel.setTextFill("white");
        generalLabel.setFont(MAIN_HEADER_FONT.toFont());
        return generalLabel.toLabel();
    }

    public static Label getButtonLabel(String text) {
        generalLabel.setText(text);
        generalLabel.setTextFill("#2ac1bc");
        generalLabel.setFont(BUTTON_FONT.toFont());
        return generalLabel.toLabel();
    }

    public static Label getPageHeader(String text) {
        generalLabel.setText(text);
        generalLabel.setTextFill("white");
        generalLabel.setFont(PAGE_HEADER_FONT.toFont());
        return generalLabel.toLabel();
    }

    public static Label getDialogHeader(String text) {
        generalLabel.setText(text);
        generalLabel.setTextFill("black");
        Font dialogFont = getDialogFont(20);
        generalLabel.setFont(dialogFont);
        return generalLabel.toLabel();
    }

    public static Label getDialogContent(String text) {
        generalLabel.setText(text);
        generalLabel.setTextFill("black");
        Font dialogFont = getDialogFont(15);
        generalLabel.setFont(dialogFont);
        return generalLabel.toLabel();
    }

    public static Label getFormLabel(String text) {
        generalLabel.setText(text);
        generalLabel.setTextFill("black");
        generalLabel.setFont(FORM_LABEL_FONT.toFont());
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
