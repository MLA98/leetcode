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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        TreeNode tempNode=root;
        List<List<Integer>> ans = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if (root == null){
            return ans;
        }
        s1.push(tempNode);
        
        while (!s1.empty() || !s2.empty()){
            List<Integer> temp = new ArrayList<>();
            while(!s1.empty()){
                
                tempNode = s1.pop();
                temp.add(tempNode.val);
                if (tempNode.left != null)
                    s2.push(tempNode.left);
                if (tempNode.right != null)
                    s2.push(tempNode.right);
            }
            if(!temp.isEmpty())
                ans.add(temp);
            temp = new ArrayList<>();
            while(!s2.empty()){
                tempNode = s2.pop();
                temp.add(tempNode.val);
                if (tempNode.right != null)
                    s1.push(tempNode.right);
                if (tempNode.left != null)
                    s1.push(tempNode.left);
            }
            if(!temp.isEmpty())
                ans.add(temp);
        }
        return ans;
    }

}

// brilliant stacks solution
// easy to implement
