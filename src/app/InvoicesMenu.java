package app;

import db.InvoiceTypes;
import db.InvoicesDataBase;

public class InvoicesMenu extends Menu implements Menuable {
    private final InvoicesDataBase invoicesDataBase = new InvoicesDataBase();
    public InvoicesMenu() {
        super(new String[]{"List invoices","List vat invoices","List prepayment invoice", "Add vat invoice","Add prepayment invoice" , "Delete invoice"}, true);
    }

    public void initialize() {
        int choice;

        do {
            this.showOptions();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> invoicesDataBase.read();
                case 2 -> invoicesDataBase.readByType(InvoiceTypes.VAT);
                case 3 -> invoicesDataBase.readByType(InvoiceTypes.PREPAYMENT);
            }
        } while (choice != this.getOptionsLength() + 1);
    }
}
