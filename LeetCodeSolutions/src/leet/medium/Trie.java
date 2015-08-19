package leet.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * No.208 Implement Trie (Prefix Tree)
 * Implement a trie with insert, search, and startsWith methods.
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
class TrieNode {
    // Initialize your data structure here.
    char val;
    List<TrieNode> list;
    public TrieNode() {
    	list = new ArrayList<TrieNode>();
    }
    
    public TrieNode(char c) {
        this.val = c;
        list = new ArrayList<TrieNode>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(null == word)
            return;
        char[] array = word.toCharArray();
        if(0 == array.length)
            return;
        insert(root, array, 0);
    }
    
    private void insert(TrieNode node, char[] array, int start) {
    	if(start >= array.length) {
    		node.list.add(new TrieNode('#'));
    		return ;
    	}
        boolean find = false;
        TrieNode findNode = null;
        for(TrieNode temp: node.list) {
            if(temp.val == array[start]) {
                find = true;
                findNode = temp;
            }
        }
        if(!find) {
            findNode = new TrieNode(array[start]);
            node.list.add(findNode);
        } 
        insert(findNode, array, start + 1);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	if(null == word || word.length() == 0)
    		return false;
		return search(root.list, word.toCharArray(), 0);
    }
    
    private boolean search(List<TrieNode> list, char[] array, int start) {
    	if(start >= array.length) {
    		for(TrieNode node: list) {
    			if(node.val == '#')
    				return true;
    		}
    		return false;
    	}
    	for(TrieNode node: list) {
    		if(node.val == array[start]) {
    			return search(node.list, array, start+1);
    		}
    	}
    	return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	if(null == prefix || prefix.length() == 0)
    		return false;
		return startsWith(root.list, prefix.toCharArray(), 0);
    }
    
    private boolean startsWith(List<TrieNode> list, char[] array, int start) {
    	if(start >= array.length)
    		return true;
    	for(TrieNode node: list) {
    		if(node.val == array[start]) {
    			return startsWith(node.list, array, start+1);
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	Trie trie = new Trie();
    	/*trie.insert("p");
    	System.out.println(trie.startsWith("pr"));
    	System.out.println(trie.search("p"));
    	trie.insert("pr");
    	System.out.println(trie.startsWith("pre"));
    	System.out.println(trie.search("pr"));
    	trie.insert("pre");
    	System.out.println(trie.startsWith("pre"));
    	System.out.println(trie.search("pre"));
    	trie.insert("pref");
    	System.out.println(trie.startsWith("pref"));
    	System.out.println(trie.search("pref"));
    	trie.insert("prefi");
    	System.out.println(trie.startsWith("pref"));
    	System.out.println(trie.search("prefi"));
    	trie.insert("prefix");
    	System.out.println(trie.startsWith("prefi"));
    	System.out.println(trie.search("prefix"));*/
    	trie.insert("ab");
    	System.out.println(trie.search("a"));
    	System.out.println(trie.startsWith("a"));
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");