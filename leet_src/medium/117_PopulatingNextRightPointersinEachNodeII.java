/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node last = root;
        Node nLast = null;
        Node tmp;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            if (tmp != last) {
                tmp.next = queue.peek();
            }
            if (tmp.left != null) {
                queue.add(tmp.left);
                nLast = tmp.left;
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
                nLast = tmp.right;
            }
            if (tmp == last) {
                last = nLast;
            }
        }
        return root;
    }
}
