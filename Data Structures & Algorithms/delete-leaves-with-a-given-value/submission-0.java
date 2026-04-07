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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return remove(root,target);
    }
    private TreeNode remove(TreeNode root,int k){
        if(root==null)return null;
        root.left=remove(root.left,k);
        root.right=remove(root.right,k);
        if(root.left==null&&root.right==null&&root.val==k)return null;
        return root;
    }
}