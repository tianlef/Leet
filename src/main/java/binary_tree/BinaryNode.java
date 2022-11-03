package binary_tree;

import lombok.Data;

@Data
public class BinaryNode {
    BinaryNode left;
    BinaryNode right;

    String value;

    BinaryNode(){}

    BinaryNode(String value) {
        this.value = value;
    }

    public void print(BinaryNode root) {
        if(root.left != null) {
            print(root.left);
        }
        System.out.println(root.value);
        if (root.right != null) {
            print(root.right);
        }
    }


    public BinaryNode search(BinaryNode root, String value) {
        if (root == null) {
            return null;
        }
        if (root.value.equals(value)) {
            return root;
        }
        else if (this.compare(root.value, value)) {
            return search(root.right,value);
        }
        else {
            return search(root.left, value);
        }
    }

    /**
     * 插入结点，返回根结点
     * @param root
     * @param value
     * @return
     */
    public BinaryNode insert(BinaryNode root, String value) {
        if (root == null) {
            return new BinaryNode(value);
        }

        if (this.compare(root.value, value)) {
            root.left = this.insert(root.left,value);
        }
        else {
            root.right = this.insert(root.right,value);
        }
        return root;
    }

    /**
     * 字典序排序函数
     *
     * @param value1
     * @param value2
     * @return true 右边大 false 右边小
     */
    public boolean compare(String value1, String value2) {
        int index = 0;
        while (index < value1.length() && index < value2.length()){
            char c1 = value1.charAt(index);
            char c2 = value2.charAt(index);
            if (c1 < c2) {
                return false;
            }
            else if (c1 > c2) {
                return true;
            }
            else {
                index++;
            }
        }
        if(index == value1.length()) {
            return false;
        }
        else{
            return true;
        }
    }
}
