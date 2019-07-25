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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else{
            if(root.right == null && root.left == null){
                root = null;
            }
            else if(root.left != null){
                int predecessor = predecessor(root);
                root.val = predecessor;
                root.left = deleteNode(root.left, root.val);
            }
            else if(root.right != null){
                int successor = successor(root);
                root.val = successor;
                root.right = deleteNode(root.right, root.val);
            }
        }
        
        return root;
    }
    
    // 比node大的最小值
    private int successor(TreeNode node){
        TreeNode successor = node.right;
        while(successor.left != null){
            successor = successor.left;
        }
        
        return successor.val;
    }
    
    // 比node小的最大值在左边child的最右孙
    private int predecessor(TreeNode node){
        TreeNode predecessor = node.left;
        
        while(predecessor.right != null){
            predecessor = predecessor.right;
        }
        
        return predecessor.val;
    }
}