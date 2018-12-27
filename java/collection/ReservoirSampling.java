// https://www.dailycodingproblem.com/blog/how-to-pick-a-random-element-from-an-infinite-stream/
// https://www.geeksforgeeks.org/select-a-random-number-from-stream-with-o1-space/
// https://www.geeksforgeeks.org/reservoir-sampling/
class Solution {
    public static int reservoirSmapling (int [] arr) {
        int result =  arr[0];
        Random random = new Random();
        for(int i = 1; i < arr.length; i++) {
            int r = random.nextInt(i+1);
            if (r == i) {
                result = arr[i];
            }
        }
        return result;
    }
    
    public static int[] reservoirSamplingK(int[] arr, int k) {
        int reseult = new int[k];
        int i;
        for (i = 0; i < k; i++) {
            result[i] = arr[i]
        }
        
        Random rand = new Random();
        
        for (; i < arr.length; i++) {
            int r = random.nextInt(i+1);
            if (r < k) {
                result[k] =  arr[i];
            } 
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(reservoirSmapling(new int[]{1,2,3,4,5}));
    }
}