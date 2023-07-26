package Project1B;

public class ArrayDeque<T> implements Deque<T> {

    private int headIndex = 9;
    private int tailIndex = 10;

    private int headDequeSize = 10;
    private int tailDequeSize = 10;

    private int emptySpaceInHead = 10;
    private int emptySpaceInTail = 10;

    private int size = 20;

    T[] data;

    public ArrayDeque() {
        data = (T[]) new Object[size];
    }

    @Override
    public void addFirst(T item) {
        if (headIndex == 0) {
            createSpaceInHead(headDequeSize);
        }
        data[headIndex] = item;
        headIndex--;
        emptySpaceInHead--;
    }

    @Override
    public void addLast(T item) {
        if (tailIndex - headDequeSize == tailDequeSize - 1) {
            createSpaceInTail(tailDequeSize);
        }
        data[tailIndex] = item;
        tailIndex++;
        emptySpaceInTail--;
    }

    @Override
    public int size() {
        return (tailDequeSize - emptySpaceInTail) + (headDequeSize - emptySpaceInHead);
    }

    @Override
    public T removeFirst() {
        if (emptySpaceInHead >= 0.75 * headDequeSize) {
            removeSpaceInHead(headDequeSize);
        }
        T x = data[++headIndex];
        data[headIndex] = null;

        emptySpaceInHead++;

        return x;
    }

    @Override
    public T removeLast() {
        T x;
        if (emptySpaceInTail >= 0.75 * tailDequeSize) {
            removeSpaceInTail(tailDequeSize);
        }
        x = data[--tailIndex];
        data[tailIndex] = null;

        emptySpaceInTail++;

        return x;
    }

    @Override
    public T get(int index) {
        return data[headIndex + index];
    }

    private void createSpaceInHead(int size) {
        T[] newData = (T[]) new Object[this.size + size * 2];
        System.arraycopy(data, headIndex, newData, size * 2, data.length);
        headDequeSize *= 3;
        emptySpaceInHead += size * 2;
        headIndex = size * 2;
        tailIndex += size * 2;
        this.size += size * 2;
        data = newData;
    }

    private void createSpaceInTail(int size) {
        T[] newData = (T[]) new Object[this.size + size * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        tailDequeSize *= 3;
        emptySpaceInTail += size * 2;
        this.size += size * 2;
        data = newData;
    }

    private void removeSpaceInHead(int size) {
        T[] newData = (T[]) new Object[this.size - size / 2];
        System.arraycopy(data, size / 2, newData, 0, newData.length);
        headDequeSize -= headDequeSize / 2;
        emptySpaceInHead -= size / 2;
        headIndex -= size / 2;
        tailIndex -= size / 2;
        this.size -= size / 2;
        data = newData;
    }

    private void removeSpaceInTail(int size) {
        T[] newData = (T[]) new Object[this.size - size / 2];
        System.arraycopy(data, 0, newData, 0, newData.length);
        tailDequeSize -= size / 2;
        emptySpaceInTail -= size / 2;
        this.size -= size / 2;
        data = newData;
    }

    @Override
    public void print() {
        for (int i = headIndex + 1; i < tailIndex; i++) {
            System.out.print(data[i]);
        }
    }
}
