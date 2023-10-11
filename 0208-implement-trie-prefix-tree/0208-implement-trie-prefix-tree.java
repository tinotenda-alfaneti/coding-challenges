class Trie {
    
    class TrieNode {
        boolean endsHere = false;
        TrieNode[] child;
        
        TrieNode() {
            this.child = new TrieNode[26];
        }
    }
    
    public TrieNode root;

    public Trie() {
        
        root = new TrieNode();
        
    }
    
    public void insert(String word) {
        
        TrieNode currNode = root;
        
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (currNode.child[index] == null) {
                currNode.child[index] = new TrieNode();
            }
            currNode = currNode.child[index];
        }
        currNode.endsHere = true;   
    }
    
    public boolean search(String word) {
        
        TrieNode currNode = root;
        
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            
            if (currNode.child[index] == null) {
                return false;
            }
            currNode = currNode.child[index];
        }
        
        return currNode.endsHere;
        
    }
    
    public boolean startsWith(String prefix) {
        
        TrieNode currNode = root;
        
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            
            if (currNode.child[index] == null) {
                return false;
            }
            currNode = currNode.child[index];
        }
        
        return true;
        
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */