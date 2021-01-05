package woowa.lms.front.component.image;

import lombok.Getter;

public enum ImageType {
    LOGO("Logo.png"),
    ABOUT("icon/About.png"),
    BOOK("icon/Books.png"),
    USER("icon/Users.png"),
    SIGN_UP("icon/SignUp.png"),
    SIGN_IN("icon/SignIn.png"),
    SIGN_OUT("icon/SignOut.png"),

    SUCCESS("icon/Success.png"),
    ERROR("icon/Error.png"),
    CONFIRM("icon/Confirm.png"),
    WARNING("icon/ExitDialog.png"),
    OK("icon/Check.png"),
    CANCEL("icon/Cancel.png"),
    CLOSE("icon/Close.png"),
    EXIT("icon/Exit.png"),

    VIEW_BOOK("icon/book/books.png"),
    ADD_BOOK("icon/book/add.png"),
    EDIT_BOOK("icon/book/edit.png"),
    DELETE_BOOK("icon/book/delete.png"),
    LEND_BOOK("icon/book/lend.png"),
    RETURN_BOOK("icon/book/return.png"),
    SEARCH_BOOK("icon/book/search.png"),

    VIEW_USER("icon/customer/customers.png"),
    ADD_USER("icon/customer/add.png"),
    EDIT_USER("icon/customer/edit.png"),
    DELETE_USER("icon/customer/delete.png"),
    SEARCH_USER("icon/customer/search.png");


    private static final String URL = "file:src/main/resources/image/";

    @Getter
    private final String imageUrl;

    ImageType(String imageUrl) {
        this.imageUrl = URL + imageUrl;
    }
}
