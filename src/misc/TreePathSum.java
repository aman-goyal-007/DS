package misc;

public class TreePathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + hasPath(root, 23));
        System.out.println("Tree has path: " + hasPath(root, 16));
    }

    public static boolean hasPath(TreeNode node, int sum){
        if(node == null){
            return false;
        }
        if(node.value == sum && node.left ==null && node.right == null){
            return true;
        }

        return hasPath(node.left,sum-node.value) || hasPath(node.right,sum-node.value);
    }
}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int v){
        value = v;
    }
}
