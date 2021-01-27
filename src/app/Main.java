package app;

import db.CustomersDataBase;
import db.InvoicesDataBase;
import models.DataBase;
import models.Menu;

public class Main {
    public static void main(String[] args) {
        DataBase customersDataBase = CustomersDataBase.getInstance();
        DataBase invoicesDataBase = InvoicesDataBase.getInstance();
        Menu customersMenu = new CustomersMenu(customersDataBase);
        Menu invoicesMenu = new InvoicesMenu(invoicesDataBase);
        Menu mainMenu = new MainMenu(invoicesMenu, customersMenu);

        mainMenu.initialize();
    }
}
