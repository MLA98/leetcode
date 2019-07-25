/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    class Node {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int subtreeSize = 0;
        boolean isBST = true;
    }
    
    public int largestBSTSubtree(TreeNode root) {
        Node rootNode = helper(root);
        return rootNode.subtreeSize;
    }
    
    private Node helper(TreeNode root){
        Node node = new Node();
        if(root == null){
            return node;
        }
        
        if(root.left == null && root.right == null){
            node.max = root.val;
            node.min = root.val;
            node.subtreeSize = 1;
            return node;
        }
        
        Node left = helper(root.left);
        Node right = helper(root.right);
        
        if(left.isBST == false || right.isBST == false){
            node.isBST = false;
            node.subtreeSize = Math.max(left.subtreeSize, right.subtreeSize);
        }
        else{
            // 因为max和min的默认值分别是最大和最小值。
            // 因此若左右是null，这个if语句是可以进入的。
            if(root.val > left.max && root.val < right.min){
                node.isBST = true;
                // 用来处理默认值的。
                node.max = Math.max(root.val, right.max);
                node.min = Math.min(root.val, left.min);
                node.subtreeSize = left.subtreeSize + right.subtreeSize + 1;
            }
            else{
                node.subtreeSize = Math.max(left.subtreeSize, right.subtreeSize);
                node.isBST = false;
            }
        }
        
        return node;
    }
}