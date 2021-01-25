package invoice;

public class PrepaymentInvoice extends Invoice {
    private double advance;

    public PrepaymentInvoice(double price, double advance) {
        super(price);
        this.setAdvance(advance);
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }
}
