package app;

public class MainMenu extends Menu implements Menuable {
    private final InvoicesMenu invoicesMenu = new InvoicesMenu();
    private final CustomersMenu customersMenu = new CustomersMenu();

    public MainMenu() {
        super(new String[]{"Go to invoices", "Go to customers"}, false);
    }

    public void initialize() {
        int choice;

        do {
            this.showOptions();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> this.invoicesMenu.initialize();
                case 2 -> this.customersMenu.initialize();
            }
        } while (choice != this.getOptionsLength() + 1);
    }
}
