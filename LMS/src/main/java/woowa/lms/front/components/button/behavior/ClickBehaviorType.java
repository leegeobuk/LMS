package woowa.lms.front.components.button.behavior;

public enum ClickBehaviorType {
//    SHOW_ABOUT(ClickAbout.getInstance()),
    SHOW_SIGNUP(ClickSignUp.getInstance()),
    SHOW_SIGNIN(ClickSignIn.getInstance()),
    EXIT_PROGRAM(ClickExit.getInstance());

    private final ClickBehavior clickBehavior;

    ClickBehaviorType(ClickBehavior clickBehavior) {
        this.clickBehavior = clickBehavior;
    }

    public ClickBehavior getBehavior() {
        return this.clickBehavior;
    }
}
