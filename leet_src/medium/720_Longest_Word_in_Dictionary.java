class Solution {
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Tire root = new Tire();
        Arrays.sort(words);
        for (String s: words) {
            root.insert(s);
        }
        return root.maxWord;
    }

    //Tire Tree
    class Tire {
        private TireNode root;
        int MAX_SIZE = 26;
        String maxWord = "";
        int maxLength = 0;;

        public Tire() {
            root = new TireNode();
        }

        private class TireNode {
            int num;
            TireNode[] child;
            boolean isLeaveNode;
            char val;
            int length;
            String word;

            public TireNode() {
                num = 1;
                length = 0;
                child = new TireNode[MAX_SIZE];
                isLeaveNode = false;
            }
        }

        public void insert(String s) {
            if (s == null || s.length() == 0) {
                return ;
            }
            TireNode node = root;
            int length = 0;
            char[] arr = s.toCharArray();
            boolean flag = false;
            int tmpNum = Integer.MAX_VALUE;
            for (char c: arr) {
                int pos = c - 'a';
                if (node.child[pos] == null) {
                    node.child[pos] = new TireNode();
                    node.child[pos].val = c;
                } else {
                    node.child[pos].num ++;
                }
                if (node != root) {
                    if (node.child[pos].num < tmpNum && node.isLeaveNode && !flag) {
                        tmpNum = node.child[pos].num;
                    } else {
                        flag = true;
                    }
                }
                node = node.child[pos];
                node.length = ++ length;
            }
            node.isLeaveNode = true;
            node.word = s;
            if (!flag) {
                if (maxWord == "") {
                    maxLength = node.length;
                    maxWord = node.word;
                } else {
                    if (node.length > maxLength) {
                        maxLength = node.length;
                        maxWord = node.word;
                    } else if (node.length == maxLength){
                        if (node.word.compareTo(maxWord) < 0) {
                            maxWord = node.word;
                        }
                    }
                }
            }
        }
    }
}
