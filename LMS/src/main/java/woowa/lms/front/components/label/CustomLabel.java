package woowa.lms.front.components.label;

import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter @Setter
public class CustomLabel {

    @Builder.Default
    String text = "";

    @Builder.Default
    Font font = new Font(10);

    @Builder.Default
    String textFill = "black";

    public Label toLabel() {
        Label label = new Label(text);
        label.setFont(font);
        label.setTextFill(Paint.valueOf(textFill));
        return label;
    }
}
