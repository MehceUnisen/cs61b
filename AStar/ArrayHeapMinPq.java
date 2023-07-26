package AStar;

import java.util.*;

public class ArrayHeapMinPq {
    private int lastEmptySpot = 1;

    // private ArrayList<Integer> arrayHeap = new ArrayList<>();
    private int[][] arrayHeap;

    public ArrayHeapMinPq(int size) {
        arrayHeap = new int[size + 1][2];
        for (int i = 0; i < arrayHeap.length; i++) {
            arrayHeap[i][0] = -1;
            arrayHeap[i][1] = -1;
        }
    }

    public void add(int item, int weight) {
        arrayHeap[lastEmptySpot][0] = item;
        arrayHeap[lastEmptySpot][1] = weight;

        int parent = arrayHeap[parent(lastEmptySpot)][0];
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
        int smallChild = arrayHeap[smallChildIndex][0];
        if (item > smallChild && smallChild != -1) {
            swap(smallChildIndex, index);
            sinkItem(item, getIndex(item));
        }
        return;
    }

    private void floatItem(int item, int index) {
        if (index >= 1) {
            int parentIndex = parent(index);
            int parent = arrayHeap[parentIndex][0];

            if (item < parent) {
                swap(parentIndex, index);
                floatItem(item, getIndex(item));
            }
        }
        return;
    }

    private void swap(int i1, int i2) {
        int temp = arrayHeap[i1][0];
        arrayHeap[i1][0] = arrayHeap[i2][0];
        arrayHeap[i2][0] = temp;
        temp = arrayHeap[i1][1];
        arrayHeap[i1][1] = arrayHeap[i2][1];
        arrayHeap[i2][1] = temp;
    }

    private void extend() {
        int[][] x = new int[arrayHeap.length * 2][2];
        System.arraycopy(arrayHeap, 0, x, 0, arrayHeap.length);
        arrayHeap = x;
    }

    private void shrink() {
        int[][] x = new int[arrayHeap.length / 2][2];
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
            if (item == arrayHeap[i][0]) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int item) {
        for (int i = 0; i < arrayHeap.length / 2; i++) {
            if (arrayHeap[i][0] == item) {
                return true;
            }
        }
        return false;
    }

    public int getSmallest() {
        if (size() == 1) {
            throw new NoSuchElementException("There is no element in the heap!");
        }
        return arrayHeap[1][1];

    }

    public int getWeight() {
        return arrayHeap[1][0];
    }

    public int getSmallestChildIndex(int index) {
        int lC = leftChild(index);
        int rC = rightChild(index);
        if (arrayHeap[lC][0] > arrayHeap[rC][0]) {
            return rC;
        }
        return lC;
    }

    public int removeSmallest() {
        int ret = arrayHeap[1][1];
        arrayHeap[1][0] = arrayHeap[lastEmptySpot - 1][0];
        arrayHeap[1][1] = arrayHeap[lastEmptySpot - 1][1];
        arrayHeap[--lastEmptySpot][0] = -1;
        sinkItem(arrayHeap[1][0], 1);
        if ((arrayHeap.length - 1) / 4 > lastEmptySpot) {
            shrink();
        }
        return ret;
    }

    public int size() {
        return arrayHeap.length - 1;
    }

    public void changePriority(int item, int newItem) {
        int index = getIndex(item);
        arrayHeap[index][0] = newItem;

        if (item > newItem) {
            sinkItem(newItem, index);
        } else if (newItem > item) {
            floatItem(newItem, index);
        }
    }

    public void print() {
        for (int i = 1; i < lastEmptySpot; i++) {
            System.out.print(arrayHeap[i][0] + " / ");
        }
    }

    public void printWeight() {
        for (int i = 1; i < lastEmptySpot; i++) {
            System.out.print(arrayHeap[i][1] + " / ");
        }
    }

    // public static void main(String[] args) {
    // ArrayHeapMinPq x = new ArrayHeapMinPq(10_000_000);
    // x.add(30, 10);
    // x.add(23, 12);
    // x.add(10, 15);
    // x.add(27, 18);
    // x.add(46, 17);
    // x.add(24, 3);
    // x.removeSmallest();
    // // System.out.println(Duration.between(Instant.now(), starts));
    // x.print();
    // System.out.println();
    // x.printWeight();
    // }
}
