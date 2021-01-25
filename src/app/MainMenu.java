package app;

import utils.GetNumberFromUserUtil;

public class MainMenu extends Menu implements Menuable {
    private final InvoicesMenu invoicesMenu = new InvoicesMenu();
    private final CustomersMenu customersMenu = new CustomersMenu();

    public MainMenu() {
        super(new String[]{"Go to invoices", "Go to customers"}, false);
    }

    public void initialize() {
        int choice;

        try {
            do {
                this.showOptions();
                choice = GetNumberFromUserUtil.getInt("Select option:");
                switch (choice) {
                    case 1 -> this.invoicesMenu.initialize();
                    case 2 -> this.customersMenu.initialize();
                }
            } while (choice != this.getOptionsLength() + 1);
        } catch (java.util.InputMismatchException error) {
            System.out.println(error.getMessage());
        }
    }
}
