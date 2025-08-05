import java.util.*;
public class Inorder
{
    public class TreeNode{
        TreeNode left,right;
        int val;

        TreeNode(int data)
        {
            this.val=data;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private List<Integer> inorder(TreeNode node, List<Integer> result) {
        if (node != null) {
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
        }
        return result;
    }
}