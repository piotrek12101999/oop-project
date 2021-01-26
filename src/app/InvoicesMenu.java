package app;

import db.InvoiceTypes;
import invoice.Invoice;
import invoice.PrepaymentInvoice;
import invoice.VatInvoice;
import invoice.VatRate;
import models.DataBase;
import utils.GetNumberFromUserUtil;
import utils.GetStringFromUserUtil;
import utils.StringUtil;

import java.util.InputMismatchException;

public class InvoicesMenu extends Menu implements models.Menu {
    private final DataBase invoicesDataBase;
    public InvoicesMenu(DataBase invoicesDataBase) {
        super(new String[]{"List invoices","List vat invoices","List prepayment invoice", "Add vat invoice","Add prepayment invoice" , "Delete invoice"}, true);
        this.invoicesDataBase = invoicesDataBase;
    }

    private static VatRate selectVatRate() throws InputMismatchException {
        VatRate[] options = VatRate.values();
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%s: %s \n",i + 1, StringUtil.capitalize(options[i].toString()));
        }

        int choice = GetNumberFromUserUtil.getInt("Select VAT rate");

        if (choice > options.length || choice <= 0) {
            throw new InputMismatchException("Incorrect option");
        }
        return options[choice - 1];
    }

    private void createInvoice(InvoiceTypes invoiceType) {
        try {
            double price = GetNumberFromUserUtil.getDouble("Enter price:");
            Invoice invoice;

            if (invoiceType == InvoiceTypes.VAT) {
                VatRate vatRate = selectVatRate();
                invoice = new VatInvoice(price, vatRate);
            } else {
                double advance = GetNumberFromUserUtil.getDouble("Enter advance:");
                invoice = new PrepaymentInvoice(price, advance);
            }

            invoicesDataBase.create(invoice);
            System.out.printf("Created invoice with %s ID%n", invoice.getId());
        } catch (java.util.InputMismatchException error) {
        System.out.println(error.getMessage());
        }
    }

    private void deleteInvoice() {
        String id = GetStringFromUserUtil.getData("Enter invoice id", false, null);
        Invoice deletedInvoice = (Invoice) invoicesDataBase.delete(id);
        System.out.printf("Invoice with ID: %s, has been deleted%n", deletedInvoice.getId());
    }

    @Override
    public void initialize() {
        int choice;

        try {
            do {
                this.showOptions();
                choice = GetNumberFromUserUtil.getInt("Select option:");
                switch (choice) {
                    case 1 -> invoicesDataBase.read();
                    case 2 -> invoicesDataBase.readByType(InvoiceTypes.VAT);
                    case 3 -> invoicesDataBase.readByType(InvoiceTypes.PREPAYMENT);
                    case 4 -> createInvoice(InvoiceTypes.VAT);
                    case 5 -> createInvoice(InvoiceTypes.PREPAYMENT);
                    case 6 -> deleteInvoice();
                }
            } while (choice != this.getOptionsLength() + 1);
        } catch (InputMismatchException error) {
            System.out.println("Please provide number");
        }
    }
}
