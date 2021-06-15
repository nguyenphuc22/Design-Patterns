import java.util.ArrayList;
import java.util.List;

public class demo {
    public static void main(String[] args) {

        List<Item> list = new ArrayList<>();
        list.add(new Item("Phuc",18));
        list.add(new Item("An",19));
        list.add(new Item("Nam",20));
        list.add(new Item("Bang",21));


        IterableCollection collection = new MenuCollection(list);
        collection.addItem(new Item("Nick",10));
        collection.addItem(new Item("Tick", 20));

        ItemIterator itemIterator = collection.iterator();

        while (itemIterator.hasNext()) {
            Item item = (Item) itemIterator.next();
            System.out.println(item.toString());
        }
    }
}
