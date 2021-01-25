package invoice;

public class PrepaymentInvoice extends Invoice {
    private int advance;

    PrepaymentInvoice(int price, int advance) {
        super(price);
        this.setAdvance(advance);
    }

    public int getAdvance() {
        return advance;
    }

    public void setAdvance(int advance) {
        this.advance = advance;
    }
}
