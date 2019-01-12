class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int lMax = 0, rMax = 0;
        int result = 0;
        
        while (left <= right) {
            if (height[left] < height[right]) {
                if (height[left] < lMax) {
                    result += lMax - height[left];
                } else {
                    lMax = height[left];
                }
                left ++;
            } else {
                if (height[right] < rMax) {
                    result += rMax - height[right];
                } else {
                    rMax = height[right];
                }
                right --;
            }
        }
        
        return result;
        
    }
}