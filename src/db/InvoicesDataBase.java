package db;

import invoice.Invoice;
import invoice.PrepaymentInvoice;
import invoice.VatInvoice;
import utils.StringUtil;

import java.util.List;

public class InvoicesDataBase extends DataBase<Invoice, InvoiceTypes> {
    private final static InvoicesDataBase invoicesDataBase = new InvoicesDataBase();

    private InvoicesDataBase() {}

    public static InvoicesDataBase getInstance() {
        return invoicesDataBase;
    }

    private String getInvoiceDetail(Invoice invoice) {
        return String.format("ID: %s, Email: %s, Price: %s", invoice.getId(), invoice.getIssueDate(), invoice.getPrice());
    }

    private void displayVatInvoice(VatInvoice invoice) {
        System.out.printf("%s, Vat rate: %s%n", getInvoiceDetail(invoice), StringUtil.capitalize(invoice.getRate().toString()));
    }

    private void displayPrepaymentInvoice(PrepaymentInvoice invoice) {
        System.out.printf("%s, Advance: %s%n", getInvoiceDetail(invoice), invoice.getAdvance());
    }

    private void displayInvoice(Invoice invoice) {
        if (invoice instanceof VatInvoice) {
            displayVatInvoice((VatInvoice) invoice);
        } else if (invoice instanceof PrepaymentInvoice) {
            displayPrepaymentInvoice((PrepaymentInvoice) invoice);
        }
    }

    @Override
    public void display(List<Invoice> invoices) {
        invoices.forEach(this::displayInvoice);
    }
}
