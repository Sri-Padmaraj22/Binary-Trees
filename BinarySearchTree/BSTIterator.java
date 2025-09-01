package BinarySearchTree;
import java.util.Stack;
public class BSTIterator {
    public class TreeNode{
        TreeNode left,right;
        int val;

        TreeNode(int data)
        {
            this.val=data;
        }
    }
    Stack<TreeNode> st=new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode node=st.pop();
        pushAll(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    public void pushAll(TreeNode node)
    {
        while(node!=null)
        {
            st.push(node);
            node=node.left;
        }
    }
}
