package woowa.lms.front.model;

import javafx.beans.property.SimpleStringProperty;
import woowa.lms.back.domain.account.Customer;

public class CustomerModel {

    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty contact;

    public CustomerModel(Customer customer) {
        this.id = new SimpleStringProperty(customer.getId());
        this.name = new SimpleStringProperty(customer.getName());
        this.contact = new SimpleStringProperty(customer.getContact());
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty contactProperty() {
        return contact;
    }

    public String getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getContact() {
        return contact.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setContact(String contact) {
        this.contact.set(contact);
    }
}
