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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        findFrequent(root, map);
        int maxNum = 0;
        for(int key: map.keySet()) {
            if(map.get(key) > maxNum) {
                maxNum = map.get(key);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int key: map.keySet()) {
            if(map.get(key) == maxNum) {
                list.add(key);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i ++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void findFrequent(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        int sum = 0;
        if (node.left != null) {
            findFrequent(node.left, map);
            sum += node.left.val;
        }
        if (node.right != null) {
            findFrequent(node.right, map);
            sum += node.right.val;
        }
        sum += node.val;
        node.val = sum;
        if (map.containsKey(sum)) {
            map.put(sum, map.get(sum) + 1);
        } else {
            map.put(sum, 0);
        }
    }
}
