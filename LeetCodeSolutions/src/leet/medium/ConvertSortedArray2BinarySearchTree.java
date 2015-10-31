package leet.medium;

import norm.TreeNode;

/**
 * No.108 Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArray2BinarySearchTree {

	public static void main(String[] args) {

	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
        if(null == nums || 0 == nums.length) {
            return null;
        }
        TreeNode root = createTree(nums, 0, nums.length - 1);
        return root;
    }
    
    private TreeNode createTree(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        TreeNode root = new TreeNode(nums[(start+end)>>1]);
        root.left = createTree(nums, start, ((start+end)>>1) - 1);
        root.right = createTree(nums, ((start+end)>>1) + 1, end);
        return root;
    } 

}
