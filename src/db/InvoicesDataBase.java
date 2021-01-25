package db;

import invoice.Invoice;
import invoice.PrepaymentInvoice;
import invoice.VatInvoice;
import utils.StringUtil;

import java.util.List;

public class InvoicesDataBase extends DataBase<Invoice, InvoiceTypes> {
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

    private void displayInvoices(List<Invoice> invoices) {
        if (invoices.size() == 0) {
            System.out.println("There aren't any invoices");
        } else {
            invoices.forEach(this::displayInvoice);
        }
    }

    @Override
    public void read() {
        displayInvoices(items);
    }

    public void readByType(InvoiceTypes invoiceType) {
        List<Invoice> filteredInvoices = filterItemsByType(invoiceType);

        displayInvoices(filteredInvoices);
    }

}
