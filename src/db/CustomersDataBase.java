package db;

import customer.BusinessCustomer;
import customer.Customer;
import customer.PrivateCustomer;

import java.util.List;

public class CustomersDataBase extends DataBase<Customer, CustomerTypes> {
    private final static CustomersDataBase customersDataBase = new CustomersDataBase();

    private CustomersDataBase() {}

    public static CustomersDataBase getInstance() {
        return customersDataBase;
    }

    private String getCustomerDetail(Customer customer) {
        return String.format("ID: %s, Email: %s", customer.getId(), customer.getEmail());
    }

    private void displayBusinessCustomer(BusinessCustomer customer) {
        System.out.printf("%s, Tax id: %s%n", getCustomerDetail(customer), customer.getTaxID() );
    }

    private void displayPrivateCustomer(PrivateCustomer customer) {
        System.out.printf("%s, Name: %s%n", getCustomerDetail(customer), customer.getName());
    }

    private void displayCustomer(Customer customer) {
        if (customer instanceof BusinessCustomer) {
            displayBusinessCustomer((BusinessCustomer) customer);
        } else if (customer instanceof PrivateCustomer) {
            displayPrivateCustomer((PrivateCustomer) customer);
        }
    }

    @Override
    public void display(List<Customer> items) {
        items.forEach(this::displayCustomer);
    }
}
