package invoice;

import utils.GenerateIDUtil;
import models.Item;

import java.util.Date;

public abstract class Invoice implements Item {
    private final String id;
    private String issueDate;
    private double price;

    public Invoice(double price) {
        this.id = GenerateIDUtil.generateId();
        this.setPrice(price);
        this.setIssueDate(new Date().toString());
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }
}
