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
    public static final FontBuilder MAIN_HEADER_FONT = FontBuilder.builder().size(100).build();
    public static final FontBuilder BUTTON_FONT = FontBuilder.builder().size(30).build();
    public static final FontBuilder PAGE_HEADER_FONT = FontBuilder.builder().size(50).build();

    public static final FontBuilder FORM_LABEL_FONT =
        FontBuilder.builder().font(EULJIRO).size(18).build();

    private static FontBuilder generalFont = FontBuilder.builder().build();

    @Builder.Default
    private FontType font = HANNA_11;

    @Builder.Default
    private double size = 10;

    public static Font getFont(FontType font, int size) {
        generalFont.setFont(font);
        generalFont.setSize(size);
        return generalFont.toFont();
    }

    public static Font getDialogFont(int size) {
        generalFont.setFont(HANNA_11);
        generalFont.setSize(size);
        return generalFont.toFont();
    }

    @Override
    public Font toFont() {
        return Font.loadFont(font.getFontUrl(), size);
    }
}
