// http://blog.gainlo.co/index.php/2017/01/05/uber-interview-questions-permutations-array-arrays/
// https://www.geeksforgeeks.org/combinations-from-n-arrays-picking-one-element-from-each-array/

// "static void main" must be defined in a public class.
public class Main {
    
    public static List<List<Integer>> permuteArrayOfArray(List<List<Integer>> list) {
        List<List<Integer>> ans = new LinkedList<>();
        helper(ans, new LinkedList<Integer>(), list, 0);
        return ans;
    }
    
    public static void helper(List<List<Integer>> ans, List<Integer> curr, List<List<Integer>> numList, int pos) {
        if (pos == numList.size()) {
            ans.add(new LinkedList<>(curr));
            return;
        }
        for (int n: numList.get(pos)) {
            curr.add(n);
            helper(ans, curr, numList, pos + 1);
            curr.remove(curr.size() -1);
        }
        
        
    }
    
    public static void main(String[] args) {
        
        Integer[] a1 = new Integer[] {1, 2,3};
        Integer[] a2 = new Integer[] {4};
        Integer[] a3 = new Integer[] {5,6};
        
        List<List<Integer>> data = new LinkedList<>();
        data.add(new LinkedList<Integer>(Arrays.asList(a1)));
        data.add(new LinkedList<Integer>(Arrays.asList(a2)));
        data.add(new LinkedList<Integer>(Arrays.asList(a3)));
        
        List<List<Integer>> ans = permuteArrayOfArray(data);
        
        for (List<Integer> l: ans){
            for(int n: l) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        
    }
}