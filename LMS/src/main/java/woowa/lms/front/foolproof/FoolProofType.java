package woowa.lms.front.foolproof;

import lombok.Getter;
import woowa.lms.front.foolproof.signin.SignInIdFoolProof;
import woowa.lms.front.foolproof.signin.SignInPasswordFoolProof;
import woowa.lms.front.foolproof.signup.SignUpConfirmPasswordFoolProof;
import woowa.lms.front.foolproof.signup.SignUpIdFoolProof;
import woowa.lms.front.foolproof.signup.SignUpPasswordFoolProof;

public enum FoolProofType {

    SIGN_UP_ID(SignUpIdFoolProof.getInstance()),
    SIGN_UP_PW(SignUpPasswordFoolProof.getInstance()),
    SIGN_UP_CONFIRM_PW(SignUpConfirmPasswordFoolProof.getInstance()),
    NAME(NameFoolProof.getInstance()),
    CONTACT(ContactFoolProof.getInstance()),
    SIGN_IN_ID(SignInIdFoolProof.getInstance()),
    SIGN_IN_PW(SignInPasswordFoolProof.getInstance());


    @Getter
    private FieldFoolProof foolProof;

    FoolProofType(FieldFoolProof foolProof) {
        this.foolProof = foolProof;
    }
}
