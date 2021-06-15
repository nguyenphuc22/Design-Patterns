public interface IterableCollection<T> {

    void addItem(T temp);

    ItemIterator<T> iterator();

}
