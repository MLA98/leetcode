/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        rserialize(root, sb);
        return sb.toString();
    }
    
    private void rserialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append('X').append(',');
        }
        else{
            sb.append(root.val).append(',');
            rserialize(root.left, sb);
            rserialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return rdeserialize(new LinkedList<>(Arrays.asList(data.split(","))));
    }
    
    private TreeNode rdeserialize(Queue<String> Q){
        String value = Q.poll();
        if(value.equals("X")){
            return null;
        }
        else{
            TreeNode ret = new TreeNode(Integer.parseInt(value));
            ret.left = rdeserialize(Q);
            ret.right = rdeserialize(Q);
            return ret;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));