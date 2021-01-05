package woowa.lms.front.ui.form.user;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.ui.form.AbstractForm;
import woowa.lms.front.ui.table.UserTable;

import java.util.List;

import static woowa.lms.front.behavior.BehaviorType.CLOSE;
import static woowa.lms.front.behavior.BehaviorType.EDIT_USER;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_CANCEL;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_OK;
import static woowa.lms.front.component.textfield.InputType.TEXT;
import static woowa.lms.front.foolproof.FoolProofType.CONTACT;
import static woowa.lms.front.foolproof.FoolProofType.NAME;

public class EditUserForm extends AbstractForm {

    private Label nameLabel;
    private Label contactLabel;
    private InputField nameInputField = InputField.of(TEXT, NAME);
    private InputField contactInputField = InputField.of(TEXT, CONTACT);

    private static final double WIDTH = 400;
    private static final double HEIGHT = 350;
    private static final String TITLE = "Edit User Form";
    private static final String HEADER = "Edit User";
    private static final EditUserForm FORM = new EditUserForm();

    private EditUserForm() {
        super(WIDTH, HEIGHT, TITLE, HEADER);
        inputFields = List.of(nameInputField, contactInputField);
        setUpComponents();
        setUpPage();
        setFoolProof();
        setUpStage();
    }

    public static EditUserForm getForm() {
        return FORM;
    }

    @Override
    public void setUpComponents() {
        nameLabel = LabelBuilder.getFormLabel("Name");
        contactLabel = LabelBuilder.getFormLabel("Contact");

        okButton = GeneralButton.getFormButton(FORM_BUTTON_OK, EDIT_USER);
        cancelButton = GeneralButton.getFormButton(FORM_BUTTON_CANCEL, CLOSE);
        super.setUpComponents();
    }

    @Override
    public void setUpPage() {
        formPane.addRow(0, nameLabel, nameInputField.toTextField());
        formPane.addRow(1, contactLabel, contactInputField.toTextField());
        formPane.add(errorLabel, 0, 2, 2, 6);
        formPane.setMaxWidth(WIDTH * 0.65);
        formPane.setHgap(WIDTH * 0.08);
        formPane.setVgap(HEIGHT * 0.025);
        formPane.setAlignment(Pos.CENTER);
        super.setUpPage();
    }

    @Override
    public void setUpStage() {
        super.setUpStage();
        this.initOwner(UserTable.getTable());
    }
}
