package db;

import customer.BusinessCustomer;
import customer.PrivateCustomer;

public enum CustomerTypes {
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
