package invoice;

public class VatInvoice extends Invoice {
    private VatRate rate;

    public VatInvoice(double price, VatRate rate) {
        super(price);
        this.setRate(rate);
    }

    public VatRate getRate() {
        return rate;
    }

    public void setRate(VatRate rate) {
        this.rate = rate;
    }
}
