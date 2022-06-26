//Median of two sorted arrays of variable length
class Solution
{
	public double findMedianSortedArrays(int[] A, int[] B) 
	{
        int m = A.length;
        int n = B.length;
		int start = 0;
		int end = m;
		
        if(m > n)
		{
            return findMedianSortedArrays(B, A);
        }

        while(start <= end)
        {
            int i = start + (end - start) / 2;
            int j = (m + n + 1) / 2 - i;
			
            double max1 = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            double min1 = (i == m) ? Integer.MAX_VALUE : A[i];
            double max2 = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            double min2 = (j == n) ? Integer.MAX_VALUE : B[j];
            
			if(max1 <= min2 && max2 <= min1)
                return ((m + n) % 2 == 0) ? (Math.max(max1, max2) + Math.min(min1, min2)) / 2.0 : Math.max(max1, max2);
            else if(max1 > min2)
                end = i - 1;
            else
                start = i + 1;
        }
        return 0.0;
    }
}