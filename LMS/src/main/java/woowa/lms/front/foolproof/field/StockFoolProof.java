package woowa.lms.front.foolproof.field;

import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StockFoolProof implements FieldFoolProof {

    private Pattern pattern;
    private Matcher matcher;

    private static final String MESSAGE = "Stock cannot be above 9999";
    private static final String PATTERN = "^\\d{1,4}$";
    private static final StockFoolProof INSTANCE = new StockFoolProof();

    public StockFoolProof() {
        pattern = Pattern.compile(PATTERN);
    }

    public static StockFoolProof getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean validate(TextField textField) {
        matcher = pattern.matcher(textField.getText());
        return matcher.matches();
    }

    @Override
    public String sendValidationMessage() {
        return MESSAGE;
    }
}
