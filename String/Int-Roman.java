//Leetcode Q-12
//Integer to Roman
class Solution {
    public String intToRoman(int num) {
        String[] romanArr = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] intArr = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder res = new StringBuilder();
        int i=0; 
        while(i < intArr.length && num > 0) {
            if(num >= intArr[i]) {
                int n = num / intArr[i];
                num = num % intArr[i];
                while(n-- > 0)
                    res.append(romanArr[i]);
            }
            i++;
        }
        return res.toString();
    }
}