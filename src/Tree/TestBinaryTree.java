package Tree;


import java.util.*;

public class TestBinaryTree {
    /**
     * Binary Tree preorder traversal
     * recursion
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root,result);
        return result;
    }

    private void preorderTraversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            if (node.left != null) preorderTraversal(node.left, result);
            if (node.right != null) preorderTraversal(node.right,result);
        }
        else {
            return;
        }
    }

    /**
     * Binary Tree preorder traversal
     * iterate
     */
    public static List<Integer> preorderTraversalIterate(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.left);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    /**
     * inorder recursion
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root,res);
        return res;
    }

    private void inorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null ) {
            return;
        }
        if (node.left != null) {
            inorderTraversal(node.left, res);
        }
        res.add(node.val);
        if (node.right != null) {
            inorderTraversal(node.right, res);
        }
    }

    /**
     * 二叉树中序遍历
     * 迭代
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalIterate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            //先从左递归 直到遇到最左的叶子结点
            while (root != null)  {
                stack.push(root);
                root = root.left;
            }
            //按照后进先出的规则 最左的叶子节点被弹出并记录
            //当root为非叶子节点时，由于右侧的子节点没有被记录
            //因此将右侧的子节点设置为根节点，继续探索此子树的结构
            if (!stack.isEmpty()) {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * 二叉树后序遍历
     * 递归
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root,res);
        return res;
    }

    private static void postorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left != null)  {
            postorderTraversal(root.left, res);
        }
        if (root.right != null) {
            postorderTraversal(root.right, res);
        }
        res.add(root.val);
    }

    /**
     * 二叉树后序遍历
     * 迭代
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversalIterate(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        Collections.reverse(res);
        return res;
    }


    /**
     * 二叉树层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return res;
        }
        deque.add(root);
        while(!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> levelRes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = deque.remove();
                levelRes.add(cur.val);
                if (cur.left != null) deque.add(cur.left);
                if (cur.right != null) deque.add(cur.right);
            }
            res.add(levelRes);
        }
        return res;
    }

    /**
     * 寻找二叉树的最大深度
     * 因为可知根结点的深度为1 可以逐层知道其子节点的深度
     * 因此他是自顶向下的结构
     * 也可以写成自底向上的结构
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        maxDepth(root,0,res);
        return Collections.max(res);
    }
    private void maxDepth(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {
            res.add(depth);
            return;
        }
        maxDepth(root.left,depth+1,res);
        maxDepth(root.right,depth+1,res);
    }

    /**
     * 检查一颗二叉树是否是轴对称
     * 是一个自顶向下的结构
     * 需要分为左子树和右子树
     * 递归有点子难想
     * 可能需要层序遍历
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left,root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isSymmetricHelper(left.left,right.right) && isSymmetricHelper(left.right,right.left);
    }

    /**
     * 判断是否存在根结点到叶子节点的目标总和
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        TreeNode left = root.left;
        if (root.left != null) {
            left.val  += root.val;
        }
        TreeNode right = root.right;
        if (root.right != null) {
            right.val += root.val;
        }
        return hasPathSum(left,targetSum) || hasPathSum(right,targetSum);
    }











    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println( hasPathSum(root,1));
    }




}
