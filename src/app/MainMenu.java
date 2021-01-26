package app;

import utils.GetNumberFromUserUtil;
import java.util.InputMismatchException;

public class MainMenu extends Menu implements models.Menu {
    private final models.Menu invoicesMenu;
    private final models.Menu customersMenu;

    public MainMenu(models.Menu invoicesMenu, models.Menu customersMenu) {
        super(new String[]{"Go to invoices", "Go to customers"}, false);
        this.invoicesMenu = invoicesMenu;
        this.customersMenu = customersMenu;
    }

    @Override
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
        } catch (InputMismatchException error) {
            System.out.println("Provide number");
        }
    }
}
