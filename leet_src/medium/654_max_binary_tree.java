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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxValueNode(nums, 0, nums.length - 1);
    }

    /**
    * find the max TreeNode in nums[start, end]
    */
    private TreeNode maxValueNode(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        if(start == end) {
            return new TreeNode(nums[start]);
        }
        int max = nums[start];
        int maxIndex = start;
        for(int i = start + 1; i <= end; i ++) {
            if(nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = maxValueNode(nums, start, maxIndex - 1);
        node.right = maxValueNode(nums, maxIndex + 1, end);
        return node;
    }
}
