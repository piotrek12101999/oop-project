package db;

import models.Filterable;
import models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

abstract class DataBase<T extends Item, S extends Filterable> implements models.DataBase<T, S> {
    final private List<T> items = new ArrayList<>();

    public abstract void display(List<T> items);

    private List<T> getItemsByType(S type) {
        return items
                .stream()
                .filter(item -> item.getClass() == type.getType())
                .collect(Collectors.toList());
    }

    private void handleItemsDisplay(List<T> items) {
        if (items.size() == 0) {
            System.out.println("Couldn't find any records");
        } else {
            display(items);
        }
    }

    @Override
    public void read() {
        handleItemsDisplay(items);
    }

    @Override
    public void readByType(S type) {
        List<T> filteredItems = getItemsByType(type);

        handleItemsDisplay(filteredItems);
    }

    @Override
    public T create(T item) {
        items.add(item);
        return item;
    }

    @Override
    public T delete(String id) {
        T itemToDelete = items
                .stream()
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
