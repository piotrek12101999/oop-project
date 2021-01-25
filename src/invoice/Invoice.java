package invoice;

import utils.GenerateIDUtil;
import models.Itemable;

import java.util.Date;

public abstract class Invoice implements Itemable {
    private final String id;
    private String issueDate;
    private int price;

    public Invoice(int price) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }
}
