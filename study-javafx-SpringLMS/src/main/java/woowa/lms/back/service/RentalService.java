package woowa.lms.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.User;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.domain.item.Item;
import woowa.lms.back.domain.rental.Rental;
import woowa.lms.back.domain.rental.RentalItem;
import woowa.lms.back.repository.RentalRepository;
import woowa.lms.back.repository.account.AccountRepository;
import woowa.lms.back.repository.account.CustomAccountRepositoryImpl;
import woowa.lms.back.repository.item.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toUnmodifiableList;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;
    private final AccountRepository accountRepository;
    private final ItemRepository itemRepository;

    public List<User> searchBorrowedUser(Long itemId) {
        return rentalRepository.findByItem(itemId)
            .stream().map(User.class::cast).collect(toUnmodifiableList());
    }

    @Transactional
    public void lendBooks(String accountId, List<Long> itemIds) {
        List<RentalItem> rentalItems = new ArrayList<>();
        for (Long itemId : itemIds) {
            itemRepository.findById(itemId)
                .ifPresent(item -> rentalItems.add(RentalItem.create(item)));
        }

        accountRepository.findById(accountId)
            .ifPresent(account -> {
                Rental rental = Rental.create(account, rentalItems);
                rentalRepository.save(rental);
            });
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
