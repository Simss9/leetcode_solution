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
        private int totalTilt = 0;  // class-level variable to store total tilt

    public int findTilt(TreeNode root) {
    computeSubtreeSum(root);  // start post-order traversal
        return totalTilt;         // return sum of tilts
    }

    // Helper method: returns sum of subtree and updates tilt
    private int computeSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        int leftSum = computeSubtreeSum(node.left);   // sum of left subtree
        int rightSum = computeSubtreeSum(node.right); // sum of right subtree

        totalTilt += Math.abs(leftSum - rightSum);    // node tilt

        return node.val + leftSum + rightSum;   
          
        
    }
}