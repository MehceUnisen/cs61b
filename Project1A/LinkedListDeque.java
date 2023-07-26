package Project1A;

public class LinkedListDeque<T> {

    private int size = 1;
    private int headDequeSize = 1;
    private int tailDequeSize = 1;

    private int headIndex = 0;
    private int tailIndex = 0;

    private static class DeqNode<T> {
        public DeqNode(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        T data;
        DeqNode<T> next;
        DeqNode<T> prev;
    }

    private DeqNode<T> sentinel;

    public LinkedListDeque() {
        sentinel = new DeqNode<T>(null);
    }

    public void addFirst(T item) {
        if (isEmpty()) {
            insertInitial(item);
            return;
        }
        // else if (headIndex == 0) {
        // // we will create more space in front
        // createSpaceInHead();
        // }
        // // we will change the nodes data with the parameter data.
        // DeqNode<T> x = sentinel.next;
        // for (int i = 0; i < headIndex; i++) {
        // x = x.next;
        // }
        // x.data = item;
        // headIndex--;
        DeqNode<T> x = sentinel.next;

        sentinel.next = new DeqNode<T>(item);
        sentinel.next.next = x;
        sentinel.next.prev = x.prev;
        x.prev.next = sentinel.next;
        x.prev = sentinel.next;
        size++;

    }

    public void addLast(T item) {
        if (isEmpty()) {
            insertInitial(item);
            return;
        }
        DeqNode<T> x = sentinel.next.prev;

        sentinel.next.prev = new DeqNode<T>(item);
        x.next = sentinel.next.prev;
        sentinel.next.prev.prev = x;
        sentinel.next.prev.next = sentinel.next;
        size++;
        // if (tailIndex == size - 1) {
        // createSpaceInTail();
        // }

        // DeqNode<T> x = sentinel.next;
        // for (int i = 0; i < tailIndex; i++) {
        // x = x.prev;
        // }
        // x.data = item;
        // tailIndex++;
    }

    public void insertInitial(T item) {
        sentinel.next = new DeqNode<T>(item);
        sentinel.next.next = sentinel.next;
        sentinel.next.prev = sentinel.next;
    }

    public boolean isEmpty() {
        if (sentinel.next == null) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public T removeFirst() {
        DeqNode<T> x = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = x.prev;
        sentinel.next.prev.next = sentinel.next;
        size--;
        return x.data;
    }

    public T removeLast() {
        DeqNode<T> x = sentinel.next.prev;
        sentinel.next.prev = sentinel.next.prev.prev;
        sentinel.next.prev.next = sentinel.next;
        size--;
        return x.data;
    }

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

    private void createSpaceInTail() {
        DeqNode<T> x = sentinel.next.prev;

        for (int i = 0; i < tailDequeSize * 2; i++) {
            x.next = new DeqNode<T>(null);
            x.next.prev = x;
            x = x.next;
        }
        x.next = sentinel.next;
        sentinel.next.prev = x;
        size += tailDequeSize * 2;
        tailDequeSize *= 3;
    }

    private void createSpaceInHead() {
        DeqNode<T> x = sentinel.next;
        DeqNode<T> y = x.prev;
        for (int i = 0; i < headDequeSize * 2; i++) {
            x.prev = new DeqNode<T>(null);
            x.prev.next = x;
            x = x.prev;
        }
        sentinel.next = x;
        sentinel.next.prev = y;
        y.next = sentinel.next;
        size += headDequeSize * 2;
        headDequeSize *= 3;
        headIndex += headDequeSize;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        for (int i = 0; i < 100_000_000; i++) {
            if (i % 2 == 0) {
                a.addFirst(i);
            } else {
                a.addLast(i);
            }
        }
    }
}
