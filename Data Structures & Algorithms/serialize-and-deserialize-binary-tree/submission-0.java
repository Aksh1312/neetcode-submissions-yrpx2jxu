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

public class Codec {
    StringBuilder sb=new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        build(root);
        return sb.toString();
    }
    private void build(TreeNode root){
        if(root==null){
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        build(root.left);
        build(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q=new LinkedList<>();
        String[] str=data.split(",");
        for(String s:str){
            q.offer(s);
        }
        return fun(q);
    }
    private TreeNode fun(Queue<String> q){
        String str=q.poll();
        if(str.equals("#"))return null;
        TreeNode node=new TreeNode(Integer.parseInt(str));
        node.left=fun(q);
        node.right=fun(q);
        return node;
    }
}
