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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        int left=0;
        int right=n-1;
        return arrToBst(nums, right,left );


    }
    TreeNode arrToBst(int nums[], int right , int left){
        if(left>right){
            return null;

 }
 int mid = (left+right)/2;
 TreeNode root = new TreeNode(nums[mid]);
 root.left = arrToBst(nums, mid-1, left);
 root.right = arrToBst(nums,right,mid+1);
 return root;
    }
}