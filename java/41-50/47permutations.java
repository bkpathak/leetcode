// https://www.sigmainfy.com/blog/leetcode-permutations-i-and-ii.html
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if (nums.length == 0 || nums == null) return ans;
        Arrays.sort(nums);
        helper(ans, nums, 0);
        return ans;
    }
    
    private void helper(List<List<Integer>> ans, int[] nums, int pos) {
        if (pos == nums.length) {
            List<Integer> temp = new ArrayList<>();
            
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            ans.add(temp);
        }
        else {
            for (int i = pos; i < nums.length; i++) {
                if (containsDuplicate(nums, pos, i)) continue;
                swap(nums, pos, i);
                helper(ans, nums, pos+1);
                swap(nums, pos, i);
                while (i < nums.length -1 && nums[i] == nums[i+1]) i++;
            }
        }
    }
    
    private void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private boolean containsDuplicate(int[] nums, int start, int end) {
        
        for (int i =start; i < end; i++) {
            if (nums[i] == nums[end]) return true;
        }
        return false;
        
    }
}