package models;

import java.util.List;

public interface DataBase<T extends Item, S extends Filterable> {
    void read();
    void readByType(S type);
    T create(T item);
    T delete(String id);
}
