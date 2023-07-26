package Project2AB;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class ArrayHeapMinPq implements ExtrinsicMinPQ {
    private int lastEmptySpot = 1;

    // private ArrayList<Integer> arrayHeap = new ArrayList<>();
    private int[] arrayHeap;

    public ArrayHeapMinPq(int size) {
        arrayHeap = new int[size + 1];
        for (int i = 0; i < arrayHeap.length; i++) {
            arrayHeap[i] = -1;
        }
    }

    @Override
    public void add(int item) {
        arrayHeap[lastEmptySpot] = item;
        int parent = arrayHeap[parent(lastEmptySpot)];
        if (item < parent) {
            floatItem(item, lastEmptySpot);
        }
        lastEmptySpot++;

        if (lastEmptySpot == arrayHeap.length - 1) {
            extend();
        }
    }

    private void sinkItem(int item, int index) {
        int smallChildIndex = getSmallestChildIndex(index);
        int smallChild = arrayHeap[smallChildIndex];
        if (item > smallChild && smallChild != -1) {
            swap(smallChildIndex, index);
            sinkItem(item, getIndex(item));
        }
        return;
    }

    private void floatItem(int item, int index) {
        if (index >= 1) {
            int parentIndex = parent(index);
            int parent = arrayHeap[parentIndex];

            if (item < parent) {
                swap(parentIndex, index);
                floatItem(item, getIndex(item));
            }
        }
        return;
    }

    private void swap(int i1, int i2) {
        int temp = arrayHeap[i1];
        arrayHeap[i1] = arrayHeap[i2];
        arrayHeap[i2] = temp;
    }

    private void extend() {
        int[] x = new int[arrayHeap.length * 2];
        System.arraycopy(arrayHeap, 0, x, 0, arrayHeap.length);
        arrayHeap = x;
    }

    private void shrink() {
        int[] x = new int[arrayHeap.length / 2];
        System.arraycopy(arrayHeap, 0, x, 0, x.length);
        arrayHeap = x;
    }

    private int leftChild(int k) {
        return k * 2;
    }

    private int rightChild(int k) {
        return k * 2 + 1;
    }

    private int parent(int k) {
        int x = k / 2;
        if (x == 0) {
            return 1;
        }
        return x;
    }

    private int getIndex(int item) {
        for (int i = 0; i < arrayHeap.length; i++) {
            if (item == arrayHeap[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(int item) {
        for (int t : arrayHeap) {
            if (t == item) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getSmallest() {
        if (size() == 1) {
            throw new NoSuchElementException("There is no element in the heap!");
        }
        return arrayHeap[1];

    }

    public int getSmallestChildIndex(int index) {
        int lC = leftChild(index);
        int rC = rightChild(index);
        if (arrayHeap[lC] > arrayHeap[rC]) {
            return rC;
        }
        return lC;
    }

    @Override
    public int removeSmallest() {
        arrayHeap[1] = arrayHeap[lastEmptySpot - 1];
        arrayHeap[--lastEmptySpot] = -1;
        sinkItem(arrayHeap[1], 1);
        if ((arrayHeap.length - 1) / 4 > lastEmptySpot) {
            shrink();
        }
        return 0;
    }

    @Override
    public int size() {
        return arrayHeap.length - 1;
    }

    @Override
    public void changePriority(int item, int newItem) {

    }

    public void print() {
        for (int i = 1; i < lastEmptySpot; i++) {
            System.out.print(arrayHeap[i] + " / ");
        }
    }

    public static void main(String[] args) {
        Instant starts = Instant.now();
        ArrayHeapMinPq x = new ArrayHeapMinPq(100_000_000);
        x.add(30);
        x.add(23);
        x.add(10);
        x.add(27);
        x.add(46);
        x.add(24);
        x.removeSmallest();
        // x.removeSmallest();
        System.out.println(Duration.between(Instant.now(), starts));
        x.print();

    }
}
