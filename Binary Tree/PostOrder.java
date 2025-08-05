import java.util.*;
public class PostOrder {
    public class TreeNode{
        TreeNode left,right;
        int val;

        TreeNode(int data)
        {
            this.val=data;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private List<Integer> postorder(TreeNode node, List<Integer> result) {
        if (node != null) {
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.val);
        }
        return result;
    }
    
}
