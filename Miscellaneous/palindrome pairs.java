//Approach 1
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<words.length; i++)
            map.put(words[i], i);
        
        //Case 1: Empty string case
        if(map.containsKey("")) {
            int idx = map.get("");
            for(int i=0; i<words.length; i++) {
                if(idx != i && isPalindrome(words[i])) {
                    res.add(Arrays.asList(idx, i));
                    res.add(Arrays.asList(i, idx));
                }
            }
        }
        
        //Case 2: Reflective case
        for(int i=0; i<words.length; i++) {
            String reverse = new StringBuilder(words[i]).reverse().toString();
            Integer idx = map.get(reverse);
            if(idx != null && idx != i) 
                res.add(Arrays.asList(i, idx));
        }
        
        //Case 3: Special case
        for(int i=0; i<words.length; i++) {
            String cur = words[i];
            for(int cut=1; cut<cur.length(); cut++) {
                String left = cur.substring(0, cut);
                String right = cur.substring(cut);
                if(isPalindrome(left)) {
                    String rightReverse = new StringBuilder(right).reverse().toString();
                    if(map.containsKey(rightReverse)) 
                        res.add(Arrays.asList(map.get(rightReverse), i));
                }
                
                if(isPalindrome(right)) {
                    String leftReverse = new StringBuilder(left).reverse().toString();
                    if(map.containsKey(leftReverse)) 
                        res.add(Arrays.asList(i, map.get(leftReverse)));
                }
            }
        }
        return res;
    }
    
    private boolean isPalindrome(String word) {
        int i=0, j=word.length()-1;
        while(i<=j) {
            if(word.charAt(i++) != word.charAt(j--))
                return false;
        }
        return true;
    }
}

//Approach 2
class Solution {
    private static class TrieNode {
        private int index = -1;
        private TrieNode[] next = new TrieNode[26];
        private List<Integer> indices = new ArrayList<>();
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            buildTrie(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            search(root, words[i], i, res);
        }
        return res;
    }

    private void buildTrie(TrieNode root, String word, int i) {
        // creating trie from reversed word
        for (int j = word.length() - 1; j >= 0; j--) {
            int id = word.charAt(j) - 'a';
            if (root.next[id] == null) root.next[id] = new TrieNode();
            if (isPalindrome(word, 0, j)) root.indices.add(i);
            root = root.next[id];
        }
        root.index = i;
        root.indices.add(i);
    }

    private void search(TrieNode root, String word, int i, List<List<Integer>> res) {
        for (int j = 0; j < word.length(); j++) {
            if (root.index >= 0 && root.index != i && isPalindrome(word, j, word.length() - 1)) {
                res.add(Arrays.asList(i, root.index));
            }
            root = root.next[word.charAt(j) - 'a'];
            if (root == null) return;
        }
        for (int id : root.indices) {
            if (id == i) continue;
            res.add(Arrays.asList(i, id));
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}