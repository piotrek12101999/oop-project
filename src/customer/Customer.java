package customer;

import utils.GenerateIDUtil;
import models.Item;

public abstract class Customer implements Item {
    private final String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    Customer(String email) {
        this.id = GenerateIDUtil.generateId();
        this.setEmail(email);
    }
}
