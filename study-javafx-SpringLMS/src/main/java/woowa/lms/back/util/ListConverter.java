package woowa.lms.back.util;

import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.domain.item.Item;
import woowa.lms.front.model.AccountModel;
import woowa.lms.front.model.BookModel;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

public class ListConverter {

    public static List<AccountModel> toAccountModels(List<? extends Account> accounts) {
        return accounts.stream().map(AccountModel::new).collect(toUnmodifiableList());
    }

    public static List<BookModel> toBookModels(List<Book> books) {
        return books.stream().map(BookModel::new).collect(toUnmodifiableList());
    }
}
