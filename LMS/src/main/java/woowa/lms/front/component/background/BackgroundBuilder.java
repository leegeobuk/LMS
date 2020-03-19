package woowa.lms.front.component.background;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import lombok.Builder;

@Builder
public class BackgroundBuilder implements CustomBackground {

    public static final BackgroundBuilder DEFAULT_BACKGROUND = BackgroundBuilder.builder().build();
    public static final BackgroundBuilder MAIN_BACKGROUND = BackgroundBuilder.builder().paint(Paint.valueOf("#2ac1bc")).build();

    private static final CornerRadii EMPTY_RADII = CornerRadii.EMPTY;
    private static final Insets EMPTY_INSETS = Insets.EMPTY;

    @Builder.Default
    private Paint paint = Paint.valueOf("white");

    @Builder.Default
    private CornerRadii cornerRadii = EMPTY_RADII;

    @Builder.Default
    private Insets insets = EMPTY_INSETS;

    @Override
    public Background toBackground() {
        return new Background(new BackgroundFill(paint, EMPTY_RADII, EMPTY_INSETS));
    }
}
