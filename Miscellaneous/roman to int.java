//Leetcode Q-13
//Roman to Integer
//Approach 1: Traverse the string from back to get character and compare
//it from the map
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int res = map.get(s.charAt(s.length()-1));
        
        for(int i=s.length()-2; i>=0; i--) {
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }
}
//Approach 2:
class Solution {
    public int romanToInt(String s) {
        int ans = 0, num = 0;
        for(int i=s.length()-1; i>=0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            //as in roman numerals the general observation of increase in number
            //is from right to left, any subtractive number would be smaller 
            //than our current answer
            
            //any number can be repeated thrice (i.e. III), but to avoid that in 
            //subtraction cases, we multiply num by a number between 2 and 4 and 
            //compare it to answer
            if(3 * num < ans)   ans -= num;
            else ans += num;
        }
        return ans;
    }
}