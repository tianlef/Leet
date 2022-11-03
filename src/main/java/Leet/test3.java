package Leet;

public class test3 {
    public static Node joinAndSort(Node root1, Node root2) {

        Node res = new Node(root1.val);
        root1 = root1.next;
        Node current = res;
        int n = 1;
        while (root1 != null && root2 != null) {
            n++;
            if (root1.val < root2.val) {
                current.next = new Node(root1.val);
                root1 = root1.next;
                current = current.next;
            } else {
                current.next = new Node(root2.val);
                root2 = root2.next;
                current = current.next;
            }
        }
        while (root1 != null) {
            n++;
            current.next = new Node(root1.val);
            current = current.next;
            root1 = root1.next;
        }

        while (root2 != null) {
            n++;
            current.next = new Node(root2.val);
            current = current.next;
            root2 = root2.next;
        }

        /**
         * 链表排序
         * 冒泡排序
         */

        for (int i = n; i > 0; i--) {
            current = res;
            for (int j = 0; j < i; j++) {
                if (current != null && current.next != null && current.val > current.next.val) {
                    int temp = current.val;
                    current.val = current.next.val;
                    current.next.val = temp;
                }
                current = current.next;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] list1 = new int[]{4,8,1,9};
        int[] list2 =new int[]{1,6,2,4,7};
        Node node1 = create(list1);
        Node node2 = create(list2);
        Node res = joinAndSort(node1,node2);

    }

    public static Node create(int[] list) {

        Node head = new Node(list[0]);
        Node current = head;
        for (int i = 1; i < list.length; i++) {
            current.next = new Node(list[i]);
            current = current.next;
        }
        return head;
    }
}
