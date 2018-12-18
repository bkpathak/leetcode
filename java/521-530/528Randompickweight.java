class Solution {
    
    int[] w;

    public Solution(int[] w) {
        for (int i = 0; i < w.length ; i++) {
            if (i != 0) w[i] = w[i-1] + w[i];
        }    
        this.w = w;
    }
    
    public int pickIndex() {
        
       
        
        // Generate random number 0 -> cdf[w.length -1]
        
        Random rand = new Random(); 
        int randN = rand.nextInt(w[w.length-1]);
        int index = 0;;
        for (int i = 0; i < w.length; i++) {
            if (randN < w[i]) return i;
        }
        
        
       return -1; 
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

/*class Solution {

    Random random;
    int[] wSums;
    
    public Solution(int[] w) {
        this.random = new Random();
        for(int i=1; i<w.length; ++i)
            w[i] += w[i-1];
        this.wSums = w;
    }
    
    public int pickIndex() {
        int len = wSums.length;
        int idx = random.nextInt(wSums[len-1]) + 1;
        int left = 0, right = len - 1;
        // search position 
        while(left < right){
            int mid = left + (right-left)/2;
            if(wSums[mid] == idx)
                return mid;
            else if(wSums[mid] < idx)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}*/