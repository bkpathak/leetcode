/* 
Given a list of float numbers, insert “+”, “-”, “*” or “/” between each consecutive pair of numbers to find the maximum value you can get. 
For simplicity, assume that all operators are of equal precedence order and evaluation happens from left to right.

public class Main {
    
    public static long maxValue(int[] arr) {
        return helper(arr, "", 0, 0, 0);
    } 
    
    private static long helper(int[] arr, String exp, int i, long eval, long pre) {
       
        if (i == arr.length) {
            System.out.println("exp : " + exp + "=> " + eval);
            return eval;
        } 
        if (i == 0) {
                return helper(arr, exp + arr[i], i+1, arr[i], arr[i]);
        } else {
            long addEval = helper(arr, exp + " + " + arr[i], i+1, eval + arr[i], arr[i]);
            long subEval = helper(arr, exp + " - " + arr[i], i+1, eval - arr[i], -arr[i]);
            long mulEval = helper(arr, exp + " * " + arr[i], i+1, eval - pre + pre * arr[i], pre * arr[i]);
            //if (arr[i] == 0) throw new UnsupportedOperationException("Cannot divide by zero"); 
            long divEval = helper(arr, exp + " / " + arr[i], i+1, eval - pre + pre / arr[i], pre / arr[i]);
            return Math.max(Math.max(addEval, subEval), Math.max(mulEval, divEval));
        }  
    }
    
    public static void main(String[] args) {
        
        int[] arr = new int[]{1, 12, 3};
        System.out.println("ans " +maxValue(arr));
    }
}
*/

class Solution {
    public List<String> addOperators(String num, int target) {
        
        List<String> res = new LinkedList<>();
        helper(res, num, target, "", 0, 0, 0);
        return res;
        
    }
    
    private void helper(List<String> res, String num, int target, String exp, long eval, long pre, int pos){
        if (num.length() == pos) {
            if(eval == target) {
                res.add(exp);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') continue; // skip number like 00023
            long curr = Long.parseLong(num.substring(pos, i+1));
            
            if (pos == 0) {
                helper(res, num, target, exp + curr, curr, curr, i+1);
            } else {
                helper(res, num, target, exp + "+" +  curr, eval + curr, curr, i+1);
                helper(res, num, target, exp + "-" +  curr, eval - curr, -curr, i+1);
                helper(res, num, target, exp + "*" +  curr, eval - pre  + pre * curr, pre * curr, i+1);
            }
            
            
        }
        
    }
}