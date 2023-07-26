package list;

public class LinkedList {
    public int first;
    public LinkedList rest = null;

    public LinkedList(int first, LinkedList rest) {
        this.first = first;
        this.rest = rest;
    }

    public void printList() {
        if (rest == null) {
            System.out.print("-->");
            System.out.printf("( %d )\n", first);
            return;
        }
        System.out.print("-->");
        System.out.printf("( %d )", first);
        rest.printList();
    }

    public int size() {
        int size = 1;
        if (this.rest == null) {
            return 1;
        }
        size += this.rest.size();
        return size;
    }

    public int iterSize() {
        LinkedList x = this;
        int size = 0;
        while (x != null) {
            x = x.rest;
            size++;
        }
        return size;
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    public int iterGet(int i) {
        LinkedList p = this;
        for (int j = 0; j < i; j++) {
            p = p.rest;
        }
        return p.first;
    }

    public static LinkedList incrementList(LinkedList l, int x) {
        if (l.rest == null) {
            return new LinkedList(l.first + x, null);
        }
        LinkedList q = new LinkedList(l.first + x, incrementList(l.rest, x));
        return q;
    }

    public static LinkedList dicrementList(LinkedList l, int x) {
        if (l.rest == null) {
            l.first -= x;
            return null;
        }

        l.first -= x;
        dicrementList(l.rest, x);
        LinkedList q = l;
        return q;
    }

}
