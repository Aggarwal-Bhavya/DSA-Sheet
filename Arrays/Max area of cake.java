//Leetcode Q-1465
//Maximum Area of a piece of cake after horizontal and vertical cuts
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int n = horizontalCuts.length, m = verticalCuts.length;
        long mod = (long)1e9+7;
        long a = 0, b = 0;
        int prev = 0;
        //max difference in two cuts
        a = Math.max(a, h-horizontalCuts[n-1]);
        b = Math.max(b, w-verticalCuts[m-1]);
        
        for(int cut: horizontalCuts) {
            a = Math.max(a, cut-prev);
            prev = cut;
        }
        prev = 0;
        for(int cut: verticalCuts) {
            b = Math.max(b, cut-prev);
            prev = cut;
        }
        
        return (int)((a*b)%mod);
    }
}