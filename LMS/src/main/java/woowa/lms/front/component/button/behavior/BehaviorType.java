package woowa.lms.front.component.button.behavior;

import lombok.Getter;
import woowa.lms.front.component.button.behavior.home.*;

public enum BehaviorType {
    SHOW_ABOUT(ShowAbout.getInstance()),
    SHOW_SIGNUP(ShowSignUp.getInstance()),
    SHOW_SIGNIN(ShowSignIn.getInstance()),
    EXIT_PROGRAM(ExitProgram.getInstance()),
    SIGN_IN(SignIn.getInstance()),
    CLOSE(Close.getInstance());

    @Getter
    private final Behavior behavior;

    BehaviorType(Behavior behavior) {
        this.behavior = behavior;
    }

}
