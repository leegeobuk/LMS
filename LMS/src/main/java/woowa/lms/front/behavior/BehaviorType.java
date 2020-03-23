package woowa.lms.front.behavior;

import lombok.Getter;
import woowa.lms.front.behavior.home.*;

public enum BehaviorType {
    SHOW_ABOUT(ShowAbout.getInstance()),
    SHOW_SIGNUP(ShowSignUp.getInstance()),
    SHOW_SIGNIN(ShowSignIn.getInstance()),
    EXIT_PROGRAM(ExitProgram.getInstance()),
    SIGN_IN(SignIn.getInstance()),
    CLOSE(CloseForm.getInstance());

    @Getter
    private final Behavior behavior;

    BehaviorType(Behavior behavior) {
        this.behavior = behavior;
    }

}
