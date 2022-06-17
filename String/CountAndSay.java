class Solution {
    //Approach I
    public String countAndSay(int n) {
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

    //Approach II
    static String[] answers = new String[30];
    public String countAndSay(int n) {
        if(answers[n-1] != null)
            return answers[n-1];
        
        answers[0] = "1";
        for(int i=1; i<n; i++) {
            if(answers[i] == null)
                answers[i] = say(answers[i-1]);
        }
        return answers[n-1];
    }
    
    private String say(String s) {
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        int count = 1;
        
        for(int i=1; i<s.length(); i++) {
            if(prev == s.charAt(i))
                count++;
            else {
                sb.append(count);
                sb.append(prev);
                count = 1;
                prev = s.charAt(i);
            }
        }
        sb.append(count);
        sb.append(prev);
        return sb.toString();
    }
}