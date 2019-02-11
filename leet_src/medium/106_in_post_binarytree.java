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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 ||
           postorder == null || postorder.length == 0) {
            return null;
        }
        return buildTreeNode(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeNode(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR) {
        if(inL > inR || postL > postR) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postR]);
        int rootIndex = inL;
        for(int i = inL; i <= inR; i ++) {
            if(inorder[i] == postorder[postR]) {
                rootIndex = i;
                break;
            }
        }
        int rightSubTreeNum = inR - rootIndex;
        root.left = buildTreeNode(inorder, inL, rootIndex - 1, postorder, postL, postR - rightSubTreeNum - 1);
        root.right = buildTreeNode(inorder, rootIndex + 1, inR, postorder, postR - rightSubTreeNum, postR - 1);
        return root;
    }
}
