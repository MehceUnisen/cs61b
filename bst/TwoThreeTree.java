package bst;

public class TwoThreeTree {
    private class Node {
        int[] datas;
        Node[] childNodes;
        int size;
        boolean isLeaf;

        public Node(boolean isLeaf) {
            this.isLeaf = isLeaf;
        }

        private int getMinData() {
            int min = datas[0];
            for (int data : datas) {
                if (data < min)
                    min = data;
            }
            return min;
        }

        private int getMaxData() {
            int max = datas[0];
            for (int data : datas) {
                if (data > max)
                    max = data;
            }
            return max;
        }
    }

    Node root;

    public TwoThreeTree() {
        this.root = new Node(false);

    }

    public void insertNode(int data) {
        insertNode(data, this.root);
    }

    private void insertNode(int data, Node n) {

    }

    private void createParent() {

    }
}
