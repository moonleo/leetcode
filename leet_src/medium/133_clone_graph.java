/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        Node root = new Node(node.val, null);
        Map<Integer, Node> copiedMap = new HashMap<Integer, Node>();
        copiedMap.put(root.val, root);
        root.neighbors = copy(node, copiedMap);
        return root;
    }

    private List<Node> copy(Node root, Map<Integer, Node> map) {
        List<Node> list = new ArrayList<Node>();
        if(root.neighbors == null) {
            return list;
        }
        for(Node node: root.neighbors) {
            Node newNeighbor;
            if (!map.containsKey(node.val)) {
                newNeighbor = new Node(node.val, null);
                map.put(newNeighbor.val, newNeighbor);
                newNeighbor.neighbors = copy(node, map);
                list.add(newNeighbor);
            } else {
                list.add(map.get(node.val));
            }
        }
        return list;
    }
}
