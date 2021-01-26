package db;

import models.Filterable;
import models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

abstract class DataBase<T extends Item, S extends Filterable> implements models.DataBase<T, S> {
    final private List<T> items = new ArrayList<>();

    public abstract void display(List<T> items);

    private List<T> getItems() {
        return items;
    }

    private List<T> getItemsByType(S type) {
        return getItems()
                .stream()
                .filter(item -> item.getClass() == type.getType())
                .collect(Collectors.toList());
    }

    @Override
    public void read() {
        if (getItems().size() == 0) {
            System.out.println("Couldn't find any records");
        } else {
            display(getItems());
        }
    }

    @Override
    public void readByType(S type) {
        List<T> filteredItems = getItemsByType(type);

        display(filteredItems);
    }

    @Override
    public T create(T item) {
        getItems().add(item);
        return item;
    }

    @Override
    public T delete(String id) {
        T itemToDelete = getItems()
                .stream()
                .filter(item -> id.equals(item.getId()))
                .findFirst()
                .orElse(null);

        if (itemToDelete == null) {
            System.out.println("Can't find");
            return null;
        }

        getItems().remove(itemToDelete);
        return itemToDelete;
    }
}
