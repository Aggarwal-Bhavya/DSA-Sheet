class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0)
            return new ArrayList<>();
        
        //we find the index of our element and in its left and right direction
        //we look up for values closet to it meaning having minimum difference
        int index = binarySearch(arr, x);
        int left = index, right = index + 1;
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<k; i++) {
            if(left >= 0 && right < arr.length) {
                int diff1 = Math.abs(arr[left] - x);
                int diff2 = Math.abs(arr[right] - x);
                //we prepend to keep answer sorted
                if(diff1 <= diff2)
                    ans.add(0, arr[left--]);
                //right element is appended because it is greater than x
                else
                    ans.add(arr[right++]);
            } else if(left >= 0) 
                //we have added all elements from right but still k isn't zero, so 
                //we start prepending left elements
                ans.add(0, arr[left--]);
            else 
                //no more left elements, so add right elements by default
                ans.add(arr[right++]);
        }
        return ans;
    }
    
    private int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid] == x)
                return mid;
            else if(arr[mid] > x)
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return low > 0 ? low-1 : 0;
    }
}