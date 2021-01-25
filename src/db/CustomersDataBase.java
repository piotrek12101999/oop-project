package db;

import customer.BusinessCustomer;
import customer.Customer;
import customer.PrivateCustomer;

import java.util.List;

public class CustomersDataBase extends DataBase<Customer, CustomerTypes> {
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

    private void displayCustomers(List<Customer> customers) {
        if (customers.size() == 0) {
            System.out.println("There aren't any customers");
        } else {
            customers.forEach(this::displayCustomer);
        }
    }

    @Override
    public void read() {
        displayCustomers(items);
    }

    public void readByType(CustomerTypes customerType) {
        List<Customer> filteredCustomers = filterItemsByType(customerType);

        displayCustomers(filteredCustomers);
    }
}
