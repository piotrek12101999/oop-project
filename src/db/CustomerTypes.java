package db;

import customer.BusinessCustomer;
import customer.PrivateCustomer;
import models.Filterable;

public enum CustomerTypes implements Filterable {
    BUSINESS(BusinessCustomer.class),
    PRIVATE(PrivateCustomer.class);

    private final Class<?> type;

    CustomerTypes(Class<?> type) {
        this.type = type;
    }

    public Class<?> getType() {
        return this.type;
    }
}
