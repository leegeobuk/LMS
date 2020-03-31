package woowa.lms.back.service.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.Customer;
import woowa.lms.back.repository.account.AccountRepository;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerService implements AccountService<Customer> {

    private final AccountRepository<Customer> accountRepository;

    @Override
    public String signUp(Customer customer) throws IllegalStateException {
        validateDuplicate(customer);
        accountRepository.save(customer);
        return customer.getId();
    }

    private void validateDuplicate(Customer customer) throws IllegalStateException {
        Account found = accountRepository.findById(customer.getId());
        if (found != null) {
            throw new IllegalStateException("Id already exists!");
        }
    }

    @Transactional
    @Override
    public void edit(String id, String name, String contact) {
        Account account = accountRepository.findById(id);
        account.setName(name);
        account.setContact(contact);
    }

    @Override
    public Customer find(String id) {
        return (Customer) accountRepository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return accountRepository.findAll()
            .stream().map(Customer.class::cast).collect(toUnmodifiableList());
    }
}
