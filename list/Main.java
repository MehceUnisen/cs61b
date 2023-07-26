package list;

public class Main {
    public static void main(String[] args) {
        LinkedList my_ll = new LinkedList(5, new LinkedList(6, new LinkedList(7,
                new LinkedList(8, new LinkedList(9, null)))));
        LinkedList q = LinkedList.dicrementList(my_ll, 106);
        my_ll.printList();
        q.printList();
    }

}
