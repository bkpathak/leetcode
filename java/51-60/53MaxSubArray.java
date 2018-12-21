class Solution {
    public int maxSubArray(int[] A) {
        int maxSoFar = A[0];
        int maxEndHere = A[0];
        int start = 0, end = 0, s = 0;
        
        for (int i = 1; i < A.length; i++) {
            maxEndHere = maxEndHere + A[i];
            
            if (maxEndHere < A[i]) {
                maxEndHere = A[i];
                s = i;
            }
            if (maxSoFar < maxEndHere) {
                maxSoFar = maxEndHere;
                start =s;
                end = i;
            }
        }
        //System.out.println("Start: " + start + " end: " + end);
        return maxSoFar;
        
    }
}