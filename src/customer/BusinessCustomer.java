package customer;

public class BusinessCustomer extends Customer {
    private String taxID;

    public BusinessCustomer(String taxID, String email) {
        super(email);
        this.setTaxID(taxID);
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }
}
