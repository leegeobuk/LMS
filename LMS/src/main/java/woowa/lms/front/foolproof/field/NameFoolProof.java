package woowa.lms.front.foolproof.field;

import javafx.scene.control.TextField;
import woowa.lms.front.foolproof.FieldFoolProof;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameFoolProof implements FieldFoolProof {

    private Pattern pattern;
    private Matcher matcher;

    private static final String MESSAGE =
        "Name starts with a capital letter with no consecutive hyphens or whitespaces " +
        "and ends with alphabet with the length of 2 to 30";
    private static final String PATTERN =
        "^[A-Z][a-z]*[A-Z]?[a-z]+(-[A-Za-z]+)?(\\s[A-Za-z]+)*$";
    private static final NameFoolProof INSTANCE = new NameFoolProof();

    public NameFoolProof() {
        pattern = Pattern.compile(PATTERN);
    }

    public static NameFoolProof getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean validate(TextField textField) {
        matcher = pattern.matcher(textField.getText());
        return matcher.matches() && textField.getLength() <= 30;
    }

    @Override
    public String sendValidationMessage() {
        return MESSAGE;
    }
}
