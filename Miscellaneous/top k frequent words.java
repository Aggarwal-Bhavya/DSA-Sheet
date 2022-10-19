//Leetcode Q-692
//Top k frequent words
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++) 
            map.put(words[i], map.getOrDefault(words[i],0)+1);
        
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if(map.get(a) != map.get(b))
                return map.get(b) - map.get(a);
            else
                return a.compareTo(b);
        });
        pq.addAll(map.keySet());
        
        for(int i=0; i<k; i++) {
            String word = pq.remove();
            ans.add(word);
        }
        return ans;
    }
}