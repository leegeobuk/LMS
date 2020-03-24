package woowa.lms.front.component.font;

import javafx.scene.text.Font;
import lombok.Builder;
import lombok.Setter;

import static woowa.lms.front.component.font.FontType.EULJIRO;
import static woowa.lms.front.component.font.FontType.HANNA_11;

@Builder
@Setter
public class FontBuilder implements CustomFont {

    public static final FontBuilder DEFAULT_FONT = FontBuilder.builder().build();
    public static final FontBuilder PAGE_HEADER_FONT =
        FontBuilder.builder().font(HANNA_11).size(50).build();
    public static final FontBuilder FORM_LABEL_FONT = FontBuilder.builder().size(18).build();
    private static FontBuilder dialogFont = FontBuilder.builder().font(HANNA_11).build();

    @Builder.Default
    private FontType font = EULJIRO;

    @Builder.Default
    private double size = 10;

    public static FontBuilder getDialogFont(int size) {
        dialogFont.setSize(size);
        return dialogFont;
    }

    @Override
    public Font toFont() {
        return Font.loadFont(font.getFontUrl(), size);
    }
}
