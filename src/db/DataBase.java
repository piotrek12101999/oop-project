package db;

import models.Filterable;
import models.Itemable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class DataBase<T extends Itemable, S extends Filterable> {
    final protected List<T> items = new ArrayList<>();

    public T create(T item) {
        items.add(item);
        return item;
    }

    public abstract void read();

    protected List<T> filterItemsByType(S itemType) {
        return items
            .stream()
            .filter(item -> item.getClass() == itemType.getType())
            .collect(Collectors.toList());
    }

    public T delete(String id) {
        T itemToDelete = items.stream()
                .filter(item -> id.equals(item.getId()))
                .findFirst()
                .orElse(null);

        if (itemToDelete == null) {
            System.out.println("Can't find");
            return null;
        }

        items.remove(itemToDelete);
        return itemToDelete;
    }
}
