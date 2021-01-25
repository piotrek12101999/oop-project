package db;

import customer.BusinessCustomer;
import customer.Customer;
import customer.PrivateCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomersDataBase extends DataBase<Customer, CustomerTypes> {
    static final private List<Customer> customers = new ArrayList<>();

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
    public Customer create(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public void read() {
        displayCustomers(customers);
    }

    @Override
    public void readByType(CustomerTypes customerType) {
        List<Customer> filteredCustomers = customers
                .stream()
                .filter(customer -> customer.getClass() == customerType.getType())
                .collect(Collectors.toList());

        displayCustomers(filteredCustomers);
    }

    @Override
    public Customer delete(String id) {
        Customer customerToDelete = customers.stream()
                .filter(customer -> id.equals(customer.getId()))
                .findFirst()
                .orElse(null);

        if (customerToDelete == null) {
            System.out.println("No customer");
            return null;
        }

        customers.remove(customerToDelete);
        return customerToDelete;
    }
}
