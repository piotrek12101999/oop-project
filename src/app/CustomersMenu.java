package app;

import customer.BusinessCustomer;
import customer.Customer;
import customer.PrivateCustomer;
import db.CustomerTypes;
import db.CustomersDataBase;
import utils.GetStringFromUserUtil;

import java.util.regex.Pattern;

public class CustomersMenu extends Menu implements Menuable {
    private final CustomersDataBase customersDataBase = new CustomersDataBase();
    public CustomersMenu() {
        super(new String[]{"List customers", "List business customers", "List private customers" ,"Add business customer", "Add private customer" , "Delete customer"}, true);
    }

    private String getEmail() {
        Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        return GetStringFromUserUtil.getData("Enter user email", true, emailPattern);
    }

    private String getTaxID() {
        Pattern nipPattern = Pattern.compile("^[0-9]{10}$");
        return GetStringFromUserUtil.getData("Enter tax id", true, nipPattern);
    }

    private void createCustomer(CustomerTypes customerType) {
        String email = getEmail();
        Customer customer;

        if (customerType == CustomerTypes.BUSINESS) {
            String taxID = getTaxID();
            customer = new BusinessCustomer(taxID, email);
        } else {
            String name = GetStringFromUserUtil.getData("Enter user name", false, null);
            customer = new PrivateCustomer(name, email);
        }

        customersDataBase.create(customer);
        System.out.printf("Created customer with %s ID%n", customer.getId());
    }

    private void deleteCustomer() {
        String id = GetStringFromUserUtil.getData("Enter user id", false, null);
        Customer deletedCustomer = customersDataBase.delete(id);
        System.out.printf("Customer with ID: %s, has been deleted%n", deletedCustomer.getId());
    }

    public void initialize() {
        int choice;

        do {
            this.showOptions();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> customersDataBase.read();
                case 2 -> customersDataBase.readByType(CustomerTypes.BUSINESS);
                case 3 -> customersDataBase.readByType(CustomerTypes.PRIVATE);
                case 4 -> createCustomer(CustomerTypes.BUSINESS);
                case 5 -> createCustomer(CustomerTypes.PRIVATE);
                case 6 -> deleteCustomer();
            }
        } while (choice != this.getOptionsLength() + 1);
    }
}
