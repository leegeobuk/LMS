package woowa.lms.service;

import woowa.lms.domain.account.Account;
import woowa.lms.domain.rental.Rental;
import woowa.lms.domain.rental.RentalItem;
import woowa.lms.repository.AccountRepository;
import woowa.lms.repository.ItemRepository;
import woowa.lms.repository.RentalRepository;

public class RentalService {

    private final RentalRepository rentalRepository;
    private final AccountRepository accountRepository;
    private final ItemRepository itemRepository;

    public RentalService(RentalRepository rentalRepository, AccountRepository accountRepository, ItemRepository itemRepository) {
        this.rentalRepository = rentalRepository;
        this.accountRepository = accountRepository;
        this.itemRepository = itemRepository;
    }

    public Long lendBooks(String accountId, Long... itemIds) {
        Account account = accountRepository.findById(accountId);
        RentalItem[] rentalItems = new RentalItem[itemIds.length];
        for (int i = 0; i < itemIds.length; i++) {
            rentalItems[i] = RentalItem.create(itemRepository.findById(itemIds[i]));
        }

        Rental rental = Rental.create(account, rentalItems);
        rentalRepository.save(rental);
        return rental.getId();
    }

    public void returnBooks(Long rentalId) {
        rentalRepository.findById(rentalId).endRental();
    }
}
