/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    HashMap<Integer,Integer> map=new HashMap<>();
    int preindex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return cons(preorder,0,inorder.length-1);
    }
    private TreeNode cons(int[] preorder,int left,int right){
        if(left>right)return null;
        int val1=preorder[preindex++];
        TreeNode node=new TreeNode(val1);
        int val=map.get(val1);
        node.left=cons(preorder,left,val-1);
        node.right=cons(preorder,val+1,right);
        return node;
    }
}
