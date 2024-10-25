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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        if(root == null){
            return result;
        }
        q.add(root);

        while(!q.isEmpty()){

        int size = q.size();
        List<Integer> currLevel = new ArrayList<>();

        for(int i = 0; i < size; i++){
            TreeNode currNode = q.poll();
            currLevel.add(currNode.val);

            if(currNode.left != null){
                q.add(currNode.left);
            }
            if(currNode.right != null){
                q.add(currNode.right);
                 }
            }

        result.add(currLevel);
        }

        return result;
    }
}

/// BFS using queue
/// Check if null, if not proceed to add our root to the queue
/// get the size of queue (which denotes our level)
/// iterate n number of times on that level
/// every iterationn we take out the node on that level
/// we add its value to our result queue and also pluck out its right and left child
/// we add the left and right child to queue

/// T(C): O(n)
/// S(C) : O(n)
