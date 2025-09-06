package BinarySearchTree;

public class LargestBST {
     public class TreeNode {
        TreeNode left, right;
        int val;

        TreeNode(int data) {
            this.val = data;
        }
    }
    public class Nodevalue
    {
        public int minvalue,maxvalue,maxsize;
        Nodevalue(int minvalue,int maxvalue,int maxsize){
            this.minvalue=minvalue;
            this.maxvalue=maxvalue;
            this.maxsize=maxsize;
        }
    }
    public Nodevalue largestBSTHelper(TreeNode root){
        if(root==null)
        return new Nodevalue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        Nodevalue left= largestBSTHelper(root.left);
        Nodevalue right=largestBSTHelper(root.right);

        if(left.maxvalue<root.val && root.val<right.minvalue)
        return new Nodevalue(Math.min(left.minvalue,root.val),Math.max(right.maxvalue,root.val),1+left.maxsize+right.maxsize);
        else
        return new Nodevalue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxsize,right.maxsize));
    }
        public int largestBST(TreeNode root) {
            //your code goes here
            return largestBSTHelper(root).maxsize;     
        }
}
