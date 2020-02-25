package woowa.lms.domain;

import woowa.lms.domain.item.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Library {

    @Id @GeneratedValue
    @Column(name = "lib_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "library")
    private List<AccountLibrary> accountLibraries = new ArrayList<>();

    @OneToMany(mappedBy = "library")
    private List<Item> items = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public List<AccountLibrary> getAccountLibraries() {
        return accountLibraries;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return id.equals(library.id);
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                '}';
    }
}
