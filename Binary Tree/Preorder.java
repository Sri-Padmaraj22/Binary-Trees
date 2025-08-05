import java.util.*;
public class Preorder
{
    public class TreeNode{
        TreeNode left,right;
        int val;

        TreeNode(int data)
        {
            this.val=data;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private List<Integer> preorder(TreeNode node, List<Integer> result) {
        if (node != null) {
        result.add(node.val);
        preorder(node.left, result);
        preorder(node.right, result);
        }
        return result;
    }
}