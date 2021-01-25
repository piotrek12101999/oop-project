package db;

public abstract class DataBase<T, S> {
    public abstract T create(T item);

    public abstract void read();

    public abstract void readByType(S itemType);

    public abstract T delete(String id);
}
