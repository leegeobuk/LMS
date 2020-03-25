package woowa.lms.front.foolproof.signup;

import javafx.scene.control.TextField;
import woowa.lms.front.foolproof.FieldFoolProof;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpIdFoolProof implements FieldFoolProof {

    private Pattern pattern;
    private Matcher matcher;

    private static final String MESSAGE = "Id is a combination of characters and numbers starting with a character with length of 5 to 15";
    private static final String PATTERN = "^[A-Za-z][A-Za-z\\d]{4,14}$";
    private static final SignUpIdFoolProof INSTANCE = new SignUpIdFoolProof();

    public SignUpIdFoolProof() {
        pattern = Pattern.compile(PATTERN);
    }

    public static SignUpIdFoolProof getInstance() {
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
