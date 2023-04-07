package Models.Services;

import java.util.List;
public abstract class BaseService<T> {
    protected List<T> items;
    public List<T> getItems() {
        return items;
    }

    public T getItem(int index) {
        return items.get(index);
    }
}
