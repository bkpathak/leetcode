class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, nums, 0);
        return ans;
    }
    
    private void helper(List<List<Integer>> ans, int[] nums, int pos) {
        if (pos == nums.length) {
            ans.add(convertToArrayList(nums));
        } else {
            for (int i = pos ; i < nums.length; i++) {
                swap(nums, pos, i);
                helper(ans, nums, pos +1);
                swap(nums, pos, i);
            }
        }
        
    }
    
    private void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i]  = nums[j];
        nums[j] = temp;
    }
    
    private List<Integer> convertToArrayList(int[] nums) {
        List<Integer> lst = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            lst.add(nums[i]);
        }
        return lst;
    }
}