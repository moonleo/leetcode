package leet.medium;

public class AddAndSearchWord {
	
	public static void main(String[] args) {
		AddAndSearchWord aas = new AddAndSearchWord();
		aas.addWord("ran");
		aas.addWord("rune");
		aas.addWord("runner");
		aas.addWord("runs");
		aas.addWord("add");
		aas.addWord("adds");
		aas.addWord("adder");
		aas.addWord("addee");
		System.out.println(aas.search("add."));
	}
	
    Tire root;
    public AddAndSearchWord() {
        root = new Tire('#');
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        if(null == word || word.equals("")) {
            return ;
        }
        char[] array = word.toCharArray();
        addChar(array, 0, root);
    }
    
    private void addChar(char[] array, int i, Tire tire) {
        if(array.length-1 == i) {
        	if(null != tire.tires[array[i]-'a']) {
        		tire.tires[array[i]-'a'].end = true;
        	} else {
	        	Tire tmp = new Tire(array[i]);
	        	tmp.end = true;
	        	tire.tires[array[i]-'a'] = tmp;
        	}
        	return ;
        }
        char c = array[i];
        if(null == tire.tires[c-'a']) {
        	tire.tires[c-'a'] = new Tire(c);
        }
        addChar(array, i+1, tire.tires[c-'a']);
    }
    
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(null == word || word.equals("")) {
            return false;
        }
        char[] array = word.toCharArray();
        return search(array, 0, root);
    }
    
    private boolean search(char[] array, int i, Tire tire) {
    	if(i > array.length) {
    		return false;
    	}
    	char c = array[i];
    	if(i == array.length-1) {
    		for(Tire t: tire.tires) {
    			if(null != t) {
    				if((c == '.' || c == t.value) && t.end) {
            			return true;
            		}
    			}
    		}
    		return false;
    	}
    	if(c == '.') {
    		for(Tire t: tire.tires) {
    			if(null != t && search(array, i+1, t)) {
    				return true;
    			}
    		}
    		return false;
    	} else if(null != tire.tires[c-'a']) {
    		return search(array, i+1, tire.tires[c-'a']);
    	}
    	return false;
    }
    
    class Tire {
        char value;
        Tire[] tires;
        boolean end = false;
        Tire() {
        	tires = new Tire[26];
        }
        
        Tire(char c) {
            this.value = c;
            tires = new Tire[26];
        }
    }

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");
}
