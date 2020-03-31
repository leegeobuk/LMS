package woowa.lms.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.Customer;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.domain.rental.Rental;
import woowa.lms.back.domain.rental.RentalItem;
import woowa.lms.back.repository.account.AccountRepository;
import woowa.lms.back.repository.RentalRepository;
import woowa.lms.back.repository.item.ItemRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;
    private final AccountRepository<Customer> accountRepository;
    private final ItemRepository<Book> itemRepository;

    @Transactional
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
