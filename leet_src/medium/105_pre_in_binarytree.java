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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0
          || inorder == null || inorder.length == 0) {
            return null;
        }
        return buildTreeNode(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTreeNode(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR) {
        if(preL > preR || inL > inR) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preL]);
        int rootIndex = inL;
        for(int i = inL; i <= inR; i ++) {
            if(inorder[i] == preorder[preL]) {
                rootIndex = i;
                break;
            }
        }
        int leftNum = rootIndex - inL;
        root.left = buildTreeNode(preorder, inorder, preL + 1, preL + leftNum, inL, rootIndex - 1);
        root.right = buildTreeNode(preorder, inorder, preL + leftNum + 1, preR, rootIndex + 1, inR);
        return root;
    }
}
