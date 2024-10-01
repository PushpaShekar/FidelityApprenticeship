class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int d) {
        data = d;
        left=null;
        right=null;
    }
}
class BinaryTree {
    public void preOrder(TreeNode root) {
        if( root == null) {
            return;
        }
        System.out.print(root.data +" ");
        preOrder(root.left);
        preOrder(root.right);
    }
}

public class Main4 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        BinaryTree tree = new BinaryTree();
        tree.preOrder(root);
    }
}
