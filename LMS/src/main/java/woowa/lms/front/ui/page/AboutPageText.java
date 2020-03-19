package woowa.lms.front.ui.page;

import javafx.scene.text.Text;
import lombok.Builder;
import woowa.lms.front.component.font.FontType;

@Builder
public class AboutPageText {

    private static final String CONTENT = "Woowa Library Management System is a desktop application " +
        "that helps to manage items of library. It supports basic CRUD operations for both library " +
        "items and customers. It is designed to be extensible and easy to maintain.\nIt was developed " +
        "to show how much passion and love the developer has toward Woowa Brothers. " +
        "Should you have any inquiries or requests, feel free to contact." +
        "\n\nE-mail: leegeobuk@gmail.com\nTel: 010-9699-0080";
    private static final FontType DEFAULT_FONT = FontType.EULJIRO;
    private static final double DEFAULT_SIZE = DEFAULT_FONT.getSize();

    @Builder.Default
    private FontType font = DEFAULT_FONT;

    @Builder.Default
    private double size = DEFAULT_SIZE;

    public Text toText() {
        Text text = new Text(CONTENT);
        font.setSize(size);
        text.setFont(font.getFont());
        return text;
    }


}
