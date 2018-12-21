/*
Given an array of positive numbers, find the maximum 
sum of a subsequence with the constraint that no 2 
numbers in the sequence should be adjacent in the array. 
So 3 2 7 10 should return 13 (sum of 3 and 10) 
or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).
Answer the question in most efficient way.
*/
public class Main {
    
    // Recursive
    public static int findMax(int[] arr ,int i) {
        if (i == 0) return arr[0];
        if (i == 1) return Math.max(arr[0], arr[1]);
        return Math.max(findMax(arr, i-1), arr[i] + findMax(arr, i-2));
        
    }
    
    // DP
    
    public static int findMaxDP(int[] arr ,int j) {
        int incl = arr[0];
        int excl = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = incl;
            incl = excl + arr[i];
            excl = temp;
        }
        
        return Math.max(incl, excl);
    }
    public static void main(String[] args) {
        int[] arr = new int[] {2,4,6,2,5};
        System.out.println(findMaxDP(arr, arr.length - 1));
    }
}