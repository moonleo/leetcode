package leet.medium;

import java.util.LinkedList;
import java.util.Queue;

import norm.TreeNode;

public class SerializeAndDeserializeBinaryTree {

	public static void main(String[] args) {
		SerializeAndDeserializeBinaryTree t = new SerializeAndDeserializeBinaryTree();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		System.out.println(t.serializeTreeByLevel(node1));
		System.out.println(t.deserializeByLevel(t.serializeTreeByLevel(node1)));
	}
	
	public String serialize(TreeNode root) {
        return serializeTreeInOrder(root);
    }
    
	//前序遍历序列化
    private String serializeTreeInOrder(TreeNode root) {
        if(null == root) {
            return "#!";
        }
        String res = root.val + "!";
        res += serializeTreeInOrder(root.left);
        res += serializeTreeInOrder(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    // 前序遍历反序列化
    public TreeNode deserialize(String data) {
        if(null == data || data.equals("")) {
            return null;
        }
        String[] tArray = data.split("!");
        Queue<String> queue = new LinkedList<String>();
        for(String s: tArray) {
            queue.offer(s);
        }
        return deserializeTree(queue);
    }
    
    private TreeNode deserializeTree(Queue<String> queue) {
        String val = queue.poll();
        if(val.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserializeTree(queue);
        node.right = deserializeTree(queue);
        return node;
    }
    
    //层次遍历法序列化
    private String serializeTreeByLevel(TreeNode root) {
        if(null == root) {
            return "#!";
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        String res = root.val + "!";
        TreeNode node;
        while(queue.size()!=0) {
            node = queue.poll();
            if(null != node.left) {
                res += node.left.val + "!";
                queue.offer(node.left);
            } else {
                res += "#!";
            }
            if(null != node.right) {
                res += node.right.val + "!";
                queue.offer(node.right);
            } else {
                res += "#!";
            }
        }
        return res;
    }

    // Decodes your encoded data to tree.
    // 层次遍历法反序列化
    public TreeNode deserializeByLevel(String data) {
        if(null == data || data.equals("")) {
            return null;
        }
        String[] tArray = data.split("!");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int index = 0;
        TreeNode head = generateTreeNode(tArray[index++]);
        if(head == null) {
            return head;
        }
        queue.offer(head);
        TreeNode node, left, right;
        while(!queue.isEmpty()) {
            node = queue.poll();
            left = generateTreeNode(tArray[index++]);
            if(null != left) {
                node.left = left;
                queue.offer(left);
            }
            right = generateTreeNode(tArray[index++]);
            if(null != right) {
                node.right = right;
                queue.offer(right);
            }
        }
        return head;
    }
    
    private TreeNode generateTreeNode(String s) {
        if(s.equals("#")) {
            return null;
        } else {
            return new TreeNode(Integer.valueOf(s));
        }
    }

}
