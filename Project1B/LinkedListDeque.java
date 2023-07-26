package Project1B;

public class LinkedListDeque<T> implements Deque<T> {

    private int size = 1;
    private int headDequeSize = 1;
    private int tailDequeSize = 1;

    private int headIndex = 0;
    private int tailIndex = 0;

    private static class DeqNode<T> {
        public DeqNode(T data, DeqNode next, DeqNode prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        T data;
        DeqNode<T> next;
        DeqNode<T> prev;
    }

    private DeqNode<T> sentinel;

    public LinkedListDeque() {
        sentinel = new DeqNode<T>(null, sentinel, sentinel);

        size = 0;
    }

    @Override
    public void addFirst(T item) {
        if (isEmpty()) {
            insertInitial(item);
            size = 1;
            return;
        }
        DeqNode<T> x = sentinel.next;

        sentinel.next = new DeqNode<T>(item, sentinel.next, sentinel.next.prev);
        // x.prev.next = sentinel.next;
        // x.prev = sentinel.next;
        size++;

    }

    @Override
    public void addLast(T item) {
        if (isEmpty()) {
            insertInitial(item);
            size = 1;
            return;
        }

        sentinel.next.prev = new DeqNode<T>(item, sentinel.next, sentinel.next.prev);
        // sentinel.next.prev.next = sentinel.next;
        size++;
    }

    public void insertInitial(T item) {
        sentinel.next = new DeqNode<T>(item, sentinel.next, sentinel.next);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        DeqNode<T> x = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = x.prev;
        sentinel.next.prev.next = sentinel.next;
        size--;
        return x.data;
    }

    @Override
    public T removeLast() {
        DeqNode<T> x = sentinel.next.prev;
        sentinel.next.prev = sentinel.next.prev.prev;
        sentinel.next.prev.next = sentinel.next;
        size--;
        return x.data;
    }

    @Override
    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        DeqNode<T> x = sentinel.next;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x.data;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        a.addFirst(10);
        a.addFirst(11);
        a.addFirst(12);
        a.addFirst(13);
        a.addLast(14);
        a.addLast(15);
        a.addLast(16);
        a.addLast(17);
        a.print();
    }

    @Override
    public void print() {
        DeqNode x = sentinel.next;
        for (int i = 0; i < size; i++) {

            System.out.println(x.data);
            x = x.next;
        }
    }
}
