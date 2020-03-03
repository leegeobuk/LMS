package woowa.lms.service;

import woowa.lms.repository.AccountRepository;
import woowa.lms.repository.ItemRepository;
import woowa.lms.repository.LibraryRepository;

public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final AccountRepository accountRepository;
    private final ItemRepository itemRepository;

    public LibraryService(LibraryRepository libraryRepository, AccountRepository accountRepository, ItemRepository itemRepository) {
        this.libraryRepository = libraryRepository;
        this.accountRepository = accountRepository;
        this.itemRepository = itemRepository;
    }

//    public Long borrow(String accountId, Long itemId) {
//        Account account = accountRepository.findById(accountId);
//        Item item = itemRepository.findById(itemId);
//
//        AccountItem accountItem = AccountItem.of(account, item);
//        return accountItem.getId();
//    }
}
