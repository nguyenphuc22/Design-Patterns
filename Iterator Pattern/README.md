# Iterator

## Khái niệm

`Iterator` một mẫu pattern hành vi nó cho phép bạn duyệt qua các phần tử của bộ sưu tập ( collection ) mà không cần quan tâm tới cấu trúc của nó (list, stack, tree, etc....). 

## Đặt vấn đề

`Collections` là một kiểu dữ liệu được sử dụng nhiều nhất trong lập trình. Tuy nhiên, `Collection` chỉ là một mảng nhóm các đối tượng lại với nhau.

Hầu hết `collections` sẽ lưu trữ các phần tử của chúng một cách rất đơn giản. Tuy nhiên lại, tồn tại một số `collection` có cách lưu trữ rất phức tạp như stacks, trees, graphs và một số cấu trúc dữ liệu phức tạp khác.

Dù thế nào, `collections` phải cung cấp các phương thức để truy vấn đến các phần từ mà chúng lưu trữ. Cần có một cách nào đó để duyệt qua các phần tử mà không cần phải truy cập lại cấc phần tử giống nhau.

Nghe thì có vẻ dể nếu `collection` đang dùng là dạng list. Việt duyệt qua các phần tử rất dể, chỉ đơn giản dùng một dòng for. Nhưng nếu đó là một `collection` dạng phức tạp hơn thì sao ? Ví dụ như dạng cây chẳng hạn. Ban đầu bạn phải duyệt theo chiều sâu (depth-first) nhưng một ngày đẹp trời khác bạn lại phải duyệt theo chiều rộng (breadth-first). Một tháng sau, bạn truy vấn đến phần tử ngẫu nhiên. Điều này nghe lại không hề dể tí nào.

## Giải pháp

Ý tưởng chính của `Iterator` pattern là lấy hành vi duyệt phần tự của `collection` tách no ra thành một object riêng gọi là một iterator.

![](Images/solution.PNG)

Ngoài việc implementing thuật toán, một đối tượng `iterator` có thể đống gói toàn  bộ những chi tiết về quá trình duyệt như: vị trí hiện tại và còn bao nhiêu phần tử nữa thì kết thúc.

## Cấu Trúc

![](Images/struct.PNG)

- **Iterator** : là một interface hoặc abstract class khai báo các hoạt động cần thiết để duyệt qua các phần tử.
- **Concrete Iterators** : cài đặt các phương thức của Iterator, giữ index khi duyệt qua các phần tử.
- **Iterable Collection** : là một interface tạo ra một hoặc nhiều phương thức cho để lấy `interators` tương thích với `Collection`.
- **Concrete Collections** : cài đặt các phương thức Iterable Collection, nó cái đặt interface tạo Iterator trả về một Concrete Iterators thích hợp.
- **Client** : Đối tượng sử dụng Iterator Pattern.

## Ví dụ áp dụng Iterator Collection

![](Images/Vidu.PNG)

Item.java

```java
public class Item {
    private String name;
    private int age;

    public Item(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

ItemIterator.java

```java
public interface ItemIterator<T> {

    boolean hasNext();

    T next();

}
```

IterableCollection.java

```java
public interface IterableCollection<T> {

    void addItem(T temp);

    ItemIterator<T> iterator();

}
```

MenuCollection.java

```java
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
```

demo.java

```java
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
```

## Khi nào nên sử dụng

Sử dụng khi `collection` của bạn có cấu trúc phức tạp và bạn không muốn ẩn nó đi, không muốn cho clients của mình biết đến.

Sử dụng để giảm thiểu các mã trung lập khi duyệt phần tử.