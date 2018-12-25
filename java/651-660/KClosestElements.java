class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int lo = 0;
        int hi = arr.length - k;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) /2;
            
            if (x - arr[mid] > arr[mid + k] -x ) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k ; i++) {
            ans.add(arr[lo + i]);
        }
        return ans;
    }
}