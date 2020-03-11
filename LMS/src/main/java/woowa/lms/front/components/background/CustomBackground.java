package woowa.lms.front.components.background;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

public abstract class CustomBackground {

    Paint paint;
    BackgroundFill fill;
    static final CornerRadii EMPTY_RADII = CornerRadii.EMPTY;
    static final Insets EMPTY_INSETS = Insets.EMPTY;

    public CustomBackground(Paint paint) {
        this.paint = paint;
        fill = new BackgroundFill(paint, EMPTY_RADII, EMPTY_INSETS);
    }

    public abstract Background toBackground();
}
