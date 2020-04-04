package woowa.lms.front.foolproof;

import lombok.Getter;
import woowa.lms.front.foolproof.field.*;

public enum FoolProofType {

    ID(IdFoolProof.getInstance()),
    PW(PasswordFoolProof.getInstance()),
    CONFIRM_PW(ConfirmPasswordFoolProof.getInstance()),
    NAME(NameFoolProof.getInstance()),
    CONTACT(ContactFoolProof.getInstance()),
    NOT_EMPTY(NotEmptyFoolProof.getInstance());


    @Getter
    private FieldFoolProof foolProof;

    FoolProofType(FieldFoolProof foolProof) {
        this.foolProof = foolProof;
    }
}
