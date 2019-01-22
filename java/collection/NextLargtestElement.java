// "static void main" must be defined in a public class.
public class Main {
    public static int findNextLargest(int num) {
        char[] digits = (num + "").toCharArray();
        // Find number that is out of place i.e find the number that is not increasing while traversing fron right to left
        int i;
        for (i = digits.length - 2; i >= 0; i--) {
            if (digits[i] < digits[i + 1]) break;
        }
        
        // find the larger digit than th digit at i
        int j;
        for (j = digits.length - 1; j > i; j--  ) {
            if (digits[j] > digits[i]) break;
        }
        
        // swap the digit
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
        
        // swap the digits after [j,length] in ascending ordre
        
        Arrays.sort(digits, j, digits.length);
        
        // convert back to number
        
        num = Integer.parseInt(new String(digits));
        return num;
    }
    public static void main(String[] args) {
        System.out.println(findNextLargest(423862));
    }
}