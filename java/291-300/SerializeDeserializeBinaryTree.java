
// Design an algorithm to serialize and deserialize a binary tree.

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
        
        StringBuilder ser =  new StringBuilder();
        serializeR(root, ser);
        
        return ser.toString();
        
    }
    
    private void serializeR(TreeNode root, StringBuilder sb) {
        
        if (root == null) {
            sb.append("null,");
        } else {
            
            sb.append(root.val).append(",");
            serializeR(root.left, sb);
            serializeR(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        
        return deserializeR(q);
        
    }
    
    private TreeNode deserializeR(Queue<String> q){
        String val = q.poll();
        
        if (val.equals("null")) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserializeR(q);
        node.right = deserializeR(q);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));