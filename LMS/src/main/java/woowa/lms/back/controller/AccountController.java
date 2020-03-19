package woowa.lms.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import woowa.lms.back.service.AccountService;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    public void createAdmin() {

    }
}
