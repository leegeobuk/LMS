package woowa.lms.front.foolproof.signup;

import javafx.scene.control.TextField;
import woowa.lms.front.foolproof.FieldFoolProof;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameFieldFoolProof implements FieldFoolProof {

    private Pattern pattern;
    private Matcher matcher;

    private static final String MESSAGE =
        "Name starts with a capital letter with no consecutive hyphens or whitespaces " +
        "and ends with alphabet with the length of 2 to 30";
    private static final String PATTERN = "^[A-Z][a-z]+(-[a-zA-Z]+)?(\\s[A-Za-z]+)*$";
    private static final NameFieldFoolProof INSTANCE = new NameFieldFoolProof();

    public NameFieldFoolProof() {
        pattern = Pattern.compile(PATTERN);
    }

    public static NameFieldFoolProof getInstance() {
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
