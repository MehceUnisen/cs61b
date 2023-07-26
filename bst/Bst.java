package bst;

class Bst {

    private class Node {
        Node left;
        Node right;
        int data;

        public Node(Node left, Node right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }

    }

    Node root;

    public Bst(int data) {
        root = new Node(null, null, data);
    }

    public void addNode(int data) {
        addNode(data, this.root);
    }

    public int deleteNode(int data) {
        return 0;
    }

    private void addNode(int data, Node node) {
        if (node.left == null && node.data > data) {
            node.left = new Node(null, null, data);
        } else if (node.right == null && node.data < data) {
            node.right = new Node(null, null, data);
        } else if (node.data > data) {
            addNode(data, node.left);
        } else if (node.data < data) {
            addNode(data, node.right);
        }
    }

    public static void main(String[] args) {
        Bst bst = new Bst(10);
        bst.addNode(11);
        bst.addNode(13);
        bst.addNode(12);
        bst.addNode(8);
        bst.addNode(9);

        System.out.println();
    }
}