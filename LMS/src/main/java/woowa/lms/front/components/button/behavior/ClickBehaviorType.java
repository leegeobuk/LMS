package woowa.lms.front.components.button.behavior;

public enum ClickBehaviorType {
    ABOUT(ClickAbout.getInstance()),
    SIGNUP(ClickSignUp.getInstance()),
    SIGNIN(ClickSignIn.getInstance()),
    EXIT(ClickExit.getInstance());

    private final ClickBehavior clickBehavior;

    ClickBehaviorType(ClickBehavior clickBehavior) {
        this.clickBehavior = clickBehavior;
    }

    public ClickBehavior getBehavior() {
        return this.clickBehavior;
    }
}
