package woowa.lms.front.behavior;

import lombok.Getter;
import woowa.lms.front.behavior.close.*;
import woowa.lms.front.behavior.crud.book.*;
import woowa.lms.front.behavior.crud.customer.*;
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
    CLOSE(Close.getInstance()),
    EXIT_PROGRAM(ExitProgram.getInstance()),
    SIGN_UP(SignUp.getInstance()),
    SIGN_IN(SignIn.getInstance()),
    SIGN_OUT(SignOut.getInstance()),
    VIEW_BOOK(ViewBookBehavior.getInstance()),
    ADD_BOOK(AddBookBehavior.getInstance()),
    EDIT_BOOK(EditBookBehavior.getInstance()),
    DELETE_BOOK(DeleteBookBehavior.getInstance()),
    LEND_BOOK(LendBookBehavior.getInstance()),
    RETURN_BOOK(ReturnBookBehavior.getInstance()),
    SEARCH_BOOK(SearchBookBehavior.getInstance()),
    VIEW_CUSTOMER(ViewCustomerBehavior.getInstance()),
    ADD_CUSTOMER(AddCustomerBehavior.getInstance()),
    EDIT_CUSTOMER(EditCustomerBehavior.getInstance()),
    DELETE_CUSTOMER(DeleteCustomerBehavior.getInstance()),
    SEARCH_CUSTOMER(SearchCustomerBehavior.getInstance());


    @Getter
    private final Behavior behavior;

    BehaviorType(Behavior behavior) {
        this.behavior = behavior;
    }
}
