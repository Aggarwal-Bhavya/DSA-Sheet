//Leetcode Q-118
//Pascal's Triangle I
//To return a Pascal Triangle for given number of rows
//Approach 1 - Iterative Solution
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row, prev = null;
        
        for(int i=0; i<numRows; i++) {
            row = new ArrayList<Integer>();
            for(int j=0; j<=i; j++) {
                if(j==0 || j==i)
                    row.add(1);
                else
                    row.add(prev.get(j-1) + prev.get(j));
            }
            prev = row;
            ans.add(row);
        }
        return ans;
    }

//Approach 2 - Recurisve Solution
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 1) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            res.add(temp);
            return res;
        }
        List<List<Integer>> ans = generate(numRows-1);
        List<Integer> temp = new ArrayList<Integer>();
        List<Integer> prev = ans.get(ans.size()-1);
        
        temp.add(1);
        for(int i=1; i<prev.size(); i++) {
            temp.add(prev.get(i-1)+prev.get(i));
        }
        temp.add(1);
        ans.add(temp);
        return ans;
    }


//Leetcode Q-119
//Pascal's Triangle II
//To return the given rowIndex's row in Pascal Triangle
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex == 0) {
            result.add(1);
            return result;
        } 
        long val = 1;
        for(int i=0; i<=rowIndex; i++) {
            result.add((int) val);
            val = (val * (rowIndex-i))/(i+1);
        }
        return result;
    }

//Pascal's Triangle III
//Given any row number and column number and to find specific element at given 
//location according to Pascal's Traingle
//This would need a direct Combination formula usage.
//(row-1)C(column-1) 