package hw1;

public class ArrayBoundedQueue<T> implements BoundedQueue<T> {
    int capacity = 0;

    int headIndex = 0;
    int tailIndex = 0;
    int fillCount = 0;

    T[] data;

    public ArrayBoundedQueue(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    @Override
    public void enqueue(T x) {
        if (!isFull()) {
            data[tailIndex++] = x;
            fillCount++;
            tailIndex %= capacity;
        } else {
            System.out.println("yavas la gac tane enqueue ediyon");
        }
    }

    @Override
    public T dequeue() {
        if (!isEmpty()) {
            T x = data[headIndex];
            data[headIndex++] = null;

            fillCount--;
            headIndex %= capacity;

            return x;
        } else {
            System.out.println("yavas la gac tane dequeue ediyon");
            return null;
        }
    }

    @Override
    public T peek() {
        return data[headIndex];
    }

    @Override
    public void print() {
        for (int i = 0; i < capacity; i++) {
            System.out.println(data[i]);
        }
    }
}
