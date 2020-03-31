package woowa.lms.front.behavior;

import lombok.Getter;
import woowa.lms.front.behavior.close.CloseAbout;
import woowa.lms.front.behavior.close.CloseSignIn;
import woowa.lms.front.behavior.close.CloseSignUp;
import woowa.lms.front.behavior.close.ExitProgram;
import woowa.lms.front.behavior.crud.book.*;
import woowa.lms.front.behavior.show.*;
import woowa.lms.front.behavior.sign.SignIn;
import woowa.lms.front.behavior.sign.SignOut;
import woowa.lms.front.behavior.sign.SignUp;

public enum BehaviorType {
    SHOW_ABOUT(ShowAbout.getInstance()),
    SHOW_SIGN_UP(ShowSignUp.getInstance()),
    SHOW_SIGN_IN(ShowSignIn.getInstance()),
    SHOW_BOOKS(ShowBooks.getInstance()),
    SHOW_CUSTOMERS(ShowCustomers.getInstance()),
    CLOSE_ABOUT(CloseAbout.getInstance()),
    CLOSE_SIGN_UP(CloseSignUp.getInstance()),
    CLOSE_SIGN_IN(CloseSignIn.getInstance()),
    EXIT_PROGRAM(ExitProgram.getInstance()),
    SIGN_UP(SignUp.getInstance()),
    SIGN_IN(SignIn.getInstance()),
    SIGN_OUT(SignOut.getInstance()),
    VIEW_BOOK(ViewBookBehavior.getInstance()),
    ADD_BOOK(AddBookBehavior.getInstance()),
    EDIT_BOOK(EditBookBehavior.getInstance()),
    DELETE_BOOK(DeleteBookBehavior.getInstance()),
    LEND_BOOK(LendBookBehavior.getInstance()),
    RETURN_BOOK(ReturnBookBehavior.getInstance());


    @Getter
    private final Behavior behavior;

    BehaviorType(Behavior behavior) {
        this.behavior = behavior;
    }
}
