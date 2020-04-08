package woowa.lms.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.User;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.domain.rental.Rental;
import woowa.lms.back.domain.rental.RentalItem;
import woowa.lms.back.repository.RentalRepository;
import woowa.lms.back.repository.account.AccountRepository;
import woowa.lms.back.repository.item.ItemRepository;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;
    private final AccountRepository accountRepository;
    private final ItemRepository<Book> itemRepository;

    public List<User> searchUnreturnedUser(Long itemId) {
        return rentalRepository.findByItem(itemId)
            .stream().map(User.class::cast).collect(toUnmodifiableList());
    }

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

    @Transactional
    public void returnBooks(String accountId, Long itemId) {
        Rental rental = rentalRepository.findByAccount(accountId);
        rental.endRental(itemId);
        if (rental.getRentalItems().size() == 0) {
            rentalRepository.delete(rental);
        }
    }
}
