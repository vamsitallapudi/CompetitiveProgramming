
import java.util.*;
public class MaxSumOfNonAdjEle {

    public int nonAdj(int[] nums) {
        //recursive solution
        return rec(nums.length -1, nums);
    }
    private int rec(int i, int[] n) {
        //base cases
        if(i ==0) return n[0];
        if(i<0) return 0;

        // picking current element
        int pick = n[i] + rec(i-2,n);
        // not picking current element
        int nonPick = rec(i-1,n);
        return Math.max(pick, nonPick);
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String line = sc.nextLine();
            // split by spaces and parse
            String[] parts = line.trim().split(" ");
            int n = parts.length;
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            System.out.println(new MaxSumOfNonAdjEle().nonAdj(arr));
        }
    }    
}
