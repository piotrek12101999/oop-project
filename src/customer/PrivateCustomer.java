package customer;

public class PrivateCustomer extends Customer {
    private String name;

    public PrivateCustomer(String name, String email) {
        super(email);
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
