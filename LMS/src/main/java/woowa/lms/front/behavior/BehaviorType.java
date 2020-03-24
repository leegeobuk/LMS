package woowa.lms.front.behavior;

import lombok.Getter;
import woowa.lms.front.behavior.home.*;

public enum BehaviorType {
    SHOW_ABOUT(ShowAbout.getInstance()),
    SHOW_SIGN_UP(ShowSignUp.getInstance()),
    CLOSE_SIGN_UP(CloseSignUp.getInstance()),
    SHOW_SIGN_IN(ShowSignIn.getInstance()),
    CLOSE_SIGN_IN(CloseSignIn.getInstance()),
    EXIT_PROGRAM(ExitProgram.getInstance()),
    SIGN_UP(SignUp.getInstance()),
    SIGN_IN(SignIn.getInstance());

    @Getter
    private final Behavior behavior;

    BehaviorType(Behavior behavior) {
        this.behavior = behavior;
    }

}
