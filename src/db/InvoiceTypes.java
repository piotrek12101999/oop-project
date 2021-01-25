package db;

import invoice.VatInvoice;
import invoice.PrepaymentInvoice;

public enum InvoiceTypes {
    VAT(VatInvoice.class),
    PREPAYMENT(PrepaymentInvoice.class);

    private final Class<?> type;

    InvoiceTypes(Class<?> type) {
        this.type = type;
    }

    public Class<?> getType() {
        return this.type;
    }
}
