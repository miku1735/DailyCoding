


// Prefix and Suffix Search



/**
 * Design a special dictionary with some words that searchs the words in it by a prefix and a suffix.

Implement the WordFilter class:

WordFilter(string[] words) Initializes the object with the words in the dictionary.
f(string prefix, string suffix) Returns the index of the word in the dictionary, which has the prefix prefix and the suffix suffix. If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.
 

Example 1:

Input
["WordFilter", "f"]
[[["apple"]], ["a", "e"]]
Output
[null, 0]

Explanation
WordFilter wordFilter = new WordFilter(["apple"]);
wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix = "a" and suffix = 'e".
 

Constraints:

1 <= words.length <= 15000
1 <= words[i].length <= 10
1 <= prefix.length, suffix.length <= 10
words[i], prefix and suffix consist of lower-case English letters only.
At most 15000 calls will be made to the function f.
 */



class WordFilter {

    Trie prefix = null;
    Trie suffix = null;
    
    //Time : N*K
    public WordFilter(String[] words) {
        prefix = new Trie();
        suffix = new Trie();
        
        for(int i = 0; i < words.length; i++) {
            prefix.insert(words[i], i);
            suffix.insert(new StringBuilder(words[i]).reverse().toString(), i);
        }
       
    }
    
    //Time : K + N
    public int f(String pre, String suff) {
        List<Integer> pList = prefix.startswith(pre);
        List<Integer> sList = suffix.startswith(new StringBuilder(suff).reverse().toString());
        
        int i = pList.size()-1, j = sList.size()-1;
        while(i >= 0 && j >= 0) {
            if(Objects.equals(pList.get(i), sList.get(j))) return pList.get(i);
            else if(pList.get(i) > sList.get(j)) i--;
            else j--;
        }
        
        return -1;
    } 
}

class Trie {
    
    public Trie[] t;
    List<Integer> index;
    
    Trie() {
        t = new Trie[26];
        index = new ArrayList<>();
    }
    
    //insert
    public void insert(String word, int i) {
        Trie root = this;
        for(char c: word.toCharArray()) {
            if(root.t[c-'a'] == null) {
                root.t[c-'a'] = new Trie();
            }
            root = root.t[c-'a'];
            root.index.add(i);
        }
    }
    
    //startswith
    public List<Integer> startswith(String word) {
        Trie root = this;
        for(char c : word.toCharArray()) {
            if(root.t[c-'a'] == null) {
                return new ArrayList<>();
            }
            root = root.t[c-'a'];
        }
        return root.index;
    }
}




// 2nd Solution 


class WordFilter {
    HashMap<String, Integer> map = new HashMap<>();

    public WordFilter(String[] words) {
        for(int w = 0; w < words.length; w++){
            for(int i = 0; i <= 10 && i <= words[w].length(); i++){
                for(int j = 0; j <= 10 && j <= words[w].length(); j++){
                    map.put(words[w].substring(0, i) + "#" + words[w].substring(words[w].length()-j), w);
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        return (map.containsKey(prefix + "#" + suffix))? map.get(prefix + "#" + suffix) : -1;
    }
}