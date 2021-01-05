package woowa.lms.front.behavior;

import lombok.Getter;
import woowa.lms.front.behavior.book.*;
import woowa.lms.front.behavior.book.show.*;
import woowa.lms.front.behavior.close.Close;
import woowa.lms.front.behavior.close.ExitProgram;
import woowa.lms.front.behavior.main.show.ShowAbout;
import woowa.lms.front.behavior.main.show.ShowSignIn;
import woowa.lms.front.behavior.main.show.ShowSignUp;
import woowa.lms.front.behavior.main.sign.SignIn;
import woowa.lms.front.behavior.main.sign.SignOut;
import woowa.lms.front.behavior.main.sign.SignUp;
import woowa.lms.front.behavior.user.*;
import woowa.lms.front.behavior.user.show.*;

public enum BehaviorType {
    SHOW_ABOUT(ShowAbout.getInstance()),
    SHOW_SIGN_UP(ShowSignUp.getInstance()),
    SHOW_SIGN_IN(ShowSignIn.getInstance()),
    SHOW_BOOKS(ShowBookTable.getInstance()),
    SHOW_USERS(ShowUserTable.getInstance()),

    CLOSE(Close.getInstance()),
    EXIT_PROGRAM(ExitProgram.getInstance()),

    SIGN_UP(SignUp.getInstance()),
    SIGN_IN(SignIn.getInstance()),
    SIGN_OUT(SignOut.getInstance()),

    SHOW_ADD_BOOK(ShowAddBook.getInstance()),
    SHOW_EDIT_BOOK(ShowEditBook.getInstance()),
    SHOW_LEND_BOOK(ShowLendBook.getInstance()),
    SHOW_SEARCH_BOOK(ShowSearchBook.getInstance()),
    VIEW_BOOK(ViewAllBooks.getInstance()),
    ADD_BOOK(AddBook.getInstance()),
    EDIT_BOOK(EditBook.getInstance()),
    DELETE_BOOK(DeleteBook.getInstance()),
    LEND_BOOK(LendBook.getInstance()),
    SEARCH_BOOK(SearchBook.getInstance()),

    SHOW_ADD_USER(ShowAddUser.getInstance()),
    SHOW_EDIT_USER(ShowEditUser.getInstance()),
    SHOW_USER_TO_LEND(ShowUserToLend.getInstance()),
    SHOW_BORROWED_USER(ShowBorrowedUser.getInstance()),
    SHOW_SEARCH_USER(ShowSearchUser.getInstance()),
    VIEW_USER(ViewUser.getInstance()),
    ADD_USER(AddUser.getInstance()),
    EDIT_USER(EditUser.getInstance()),
    DELETE_USER(DeleteUser.getInstance()),
    SEARCH_USER(SearchUser.getInstance());


    @Getter
    private final Behavior behavior;

    BehaviorType(Behavior behavior) {
        this.behavior = behavior;
    }
}
