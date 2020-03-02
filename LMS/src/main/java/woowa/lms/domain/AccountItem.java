package woowa.lms.domain;

import woowa.lms.domain.account.Account;
import woowa.lms.domain.item.Item;

import javax.persistence.*;

@Entity
public class AccountItem {

    @Id
    @GeneratedValue
    @Column(name = "account_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public static AccountItem of(Account account, Item item) {
        AccountItem accountItem = new AccountItem();
        accountItem.setAccount(account);
        accountItem.setItem(item);
        return accountItem;
    }

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public Item getItem() {
        return item;
    }

    public void setAccount(Account account) {
        this.account = account;
        account.getAccountItems().add(this);
    }

    public void setItem(Item item) {
        this.item = item;
        item.getAccountItems().add(this);
    }
}
