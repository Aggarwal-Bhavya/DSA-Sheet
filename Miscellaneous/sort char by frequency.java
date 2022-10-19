//Leetcode Q-451
//Sort Characters ByFrequency
//Approach 1: Using hashing and max heap(PQ)
class Solution {
    public String frequencySort(String s) {
        if(s.length() == 1)
            return s;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b)-map.get(a));
        pq.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            char c = pq.remove();
            for(int i=0; i<map.get(c); i++)
                sb.append(c);
        }
        return sb.toString();
    }
}
//TC = O(nlogn) and SC = O(n)

