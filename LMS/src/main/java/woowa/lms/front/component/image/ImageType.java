package woowa.lms.front.component.image;

import lombok.Getter;

public enum ImageType {
    LOGO("Logo.png"),
    ABOUT("icon/About.png"),
    BOOK("icon/Book.png"),
    CUSTOMER("icon/Customer.png"),
    SIGN_UP("icon/SignUp.png"),
    SIGN_IN("icon/SignIn.png"),
    SIGN_OUT("icon/SignOut.png"),
    EXIT("icon/Exit.png"),
    SUCCESS("icon/Success.png"),
    ERROR("icon/Error.png"),
    CONFIRM("icon/Confirm.png"),
    WARNING("icon/ExitDialog.png"),
    OK("icon/Check.png"),
    CANCEL("icon/Cancel.png");


    private static final String URL = "file:src/main/resources/image/";

    @Getter
    private final String imageUrl;

    ImageType(String imageUrl) {
        this.imageUrl = URL + imageUrl;
    }
}
