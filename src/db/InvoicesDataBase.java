package db;

import invoice.Invoice;
import invoice.PrepaymentInvoice;
import invoice.VatInvoice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InvoicesDataBase extends DataBase<Invoice, InvoiceTypes> {
    static final private List<Invoice> invoices = new ArrayList<>();

    private String getInvoiceDetail(Invoice invoice) {
        return String.format("ID: %s, Email: %s, Price: %s", invoice.getId(), invoice.getIssueDate(), invoice.getPrice());
    }

    private void displayVatInvoice(VatInvoice invoice) {
        System.out.printf("%s, Vat rate: %s%n", getInvoiceDetail(invoice), invoice.getRate());
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
    public Invoice create(Invoice invoice) {
        invoices.add(invoice);
        return invoice;
    }

    @Override
    public void read() {
        displayInvoices(invoices);
    }

    @Override
    public void readByType(InvoiceTypes invoiceType) {
        List<Invoice> filteredInvoices = invoices
                .stream()
                .filter(invoice -> invoice.getClass() == invoiceType.getType())
                .collect(Collectors.toList());

        displayInvoices(filteredInvoices);
    }

    @Override
    public Invoice delete(String id) {
        Invoice invoiceToDelete = invoices.stream()
                .filter(invoice -> id.equals(invoice.getId()))
                .findFirst()
                .orElse(null);

        if (invoiceToDelete == null) {
            System.out.println("No invoice");
            return null;
        }

        invoices.remove(invoiceToDelete);
        return invoiceToDelete;
    }
}
