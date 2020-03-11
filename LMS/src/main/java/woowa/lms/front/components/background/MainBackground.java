package woowa.lms.front.components.background;

import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;

public class MainBackground extends CustomBackground {

    private static final Paint PAINT = Paint.valueOf("#2ac1bc");
    private static final Background BACKGROUND = new MainBackground().toBackground();

    private MainBackground() {
        super(PAINT);
    }

    public static Background getInstance() {
        return BACKGROUND;
    }

    @Override
    public Background toBackground() {
        return new Background(fill);
    }

}
