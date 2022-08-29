package Tree;

public class RedBlackTree <Key extends Comparable<Key>,Value>{
    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node {
        Key key;
        Value val;
        Node left, right;
        int N;
        boolean color;

        Node(Key key,Value val,int N, boolean color) {
            this.val = val;
            this.key = key;
            this.color = color;
            this.N = N;
        }

        private boolean isRed(Node x) {
            if (x == null) return false;
            return x.color == RED;
        }



    }
}
