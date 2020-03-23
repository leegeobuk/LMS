package woowa.lms.front.component.background;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import lombok.Builder;

@Builder
public class BackgroundBuilder implements CustomBackground {

    private static final Paint DEFAULT_PAINT = Paint.valueOf("#2ac1bc");

    public static final BackgroundBuilder DEFAULT_BACKGROUND = BackgroundBuilder.builder().build();

    @Builder.Default
    private Paint paint = DEFAULT_PAINT;

    @Builder.Default
    private CornerRadii cornerRadii = CornerRadii.EMPTY;

    @Builder.Default
    private Insets insets = Insets.EMPTY;

    @Override
    public Background toBackground() {
        return new Background(new BackgroundFill(paint, cornerRadii, insets));
    }
}
