package leet.easy;

import java.util.ArrayList;
import java.util.List;

import norm.TreeNode;

/**
 * No.257 Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.
 */
public class BinaryTreePaths {
	List<String> allPath = new ArrayList<String>();
    List<Integer> path = new ArrayList<Integer>();
    public List<String> binaryTreePaths(TreeNode root) {
        treePath(root);
        return allPath;
    }
    
    private void treePath(TreeNode root) {
        if(null == root) {
            return;
        }
        path.add(root.val);
        if(null == root.left && null == root.right) {
            allPath.add(path2String(path));
            path.remove(path.size()-1);
            return;
        }
        treePath(root.left);
        treePath(root.right);
        path.remove(path.size()-1);
    }
    
    private String path2String(List<Integer> path) {
        if(1 == path.size()) {
            return path.get(0)+"";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(path.get(0));
            for(int i=1; i<path.size();i ++) {
                sb.append("->").append(path.get(i));
            }
            return sb.toString();
        }
    }
}
