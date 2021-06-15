import java.util.ArrayList;
import java.util.List;

public class MenuCollection<T> implements IterableCollection {

    private List<T> menuItem = new ArrayList<>();

    public MenuCollection(List<T> menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public void addItem(Object temp) {
        menuItem.add((T) temp);
    }

    @Override
    public ItemIterator iterator() {
        return new MenuItemIterator();
    }

    class MenuItemIterator implements ItemIterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < menuItem.size();
        }

        @Override
        public T next() {
            return menuItem.get(currentIndex++);
        }
    }
}
