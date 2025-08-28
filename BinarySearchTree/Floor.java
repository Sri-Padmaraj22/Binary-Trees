package BinarySearchTree;

public class Floor {
    public class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int data)
        {
            val=data;
        }
    }

    public int floor(TreeNode root,int val)
    {
        int floor=-1;

        while(root!=null)
        {
            if(root.val==val)
            {
                floor=root.val;
                return floor;
            }

            if(val<root.val)
            {
                root=root.left;
            }
            else{
                floor=root.val;
                root=root.right;
            }
        }
    


        return floor;
    }
}
