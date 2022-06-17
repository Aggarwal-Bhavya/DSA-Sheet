class Solution {
    public String countAndSay(int n) {
	   //Approach I
        StringBuilder res = new StringBuilder("1");
        
        //checking base condition 
        if(n == 1)  return "1";
        
        //looping from --n because res string builder already contains base condition
        while(--n > 0) {
            StringBuilder curr = new StringBuilder();
            int count = 1;
            
            for(int i=1; i<res.length(); i++) {
                if(res.charAt(i) == res.charAt(i-1)) 
                    count++;
                else {
                    curr.append(String.valueOf(count) + String.valueOf(res.charAt(i-1)));
                    //resetting count = 1 because we are adding i-1 value to sb, and i 
                    //is currently a new value
                    count = 1;
                }
            }
            
            curr.append(String.valueOf(count) + String.valueOf(res.charAt(res.length()-1)));
            res.setLength(0);
            res.append(curr);
        }
        return res.toString();
    }
}