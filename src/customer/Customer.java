package customer;

import utils.GenerateIDUtil;
import models.Itemable;

public abstract class Customer implements Itemable {
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
