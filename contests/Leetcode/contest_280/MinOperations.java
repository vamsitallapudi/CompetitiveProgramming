import java.util.*;
import java.lang.*;

public class MinOperations {
    public int minimumOperations(int[] nums) {
        int arr[][] = new int[100001][2]; // to store max of odd and even
        int i, j, k, ans = 0;
        for (i = 0; i < nums.length; i++) {
            arr[nums[i]][i & 1]++;
        }
        for (i = 1, j = k = 0; i < 100001; i++) {
            // Adding the max freq of odd indices to max freq of even indices
            // and vice versa. It will give us how many elements we don't need to change
            ans = Math.max(ans, Math.max(arr[i][0] + k, arr[i][1] + j));
            j = Math.max(j, arr[i][0]); // max freq of even indices
            k = Math.max(k, arr[i][1]); // max freq of odd indices
        }
        return nums.length - ans;
    }

    public static void main(String[] args) {
        MinOperations s = new MinOperations();
        System.out.println(s.minimumOperations(
                new int[] {
                        69, 91, 47, 74, 75, 94, 22, 100, 43, 50, 82, 47, 40, 51, 90, 27,
                        98, 85, 47, 14, 55, 82, 52, 9, 65, 90, 86, 45, 52, 52, 95, 40, 85,
                        3, 46, 77, 16, 59, 32, 22, 41, 87, 89, 78, 59, 78, 34, 26, 71, 9, 82,
                        68, 80, 74, 100, 6, 10, 53, 84, 80, 7, 87, 3, 82, 26, 26, 14, 37, 26,
                        58, 96, 73, 41, 2, 79, 43, 56, 74, 30, 71, 6, 100, 72, 93,
                        83, 40, 28, 79, 24 }));

    }
}
// [69,91,47,74,75,94,22,100,43,50,82,47,40,51,90,27,98,85,47,14,55,82,52,9,65,90,86,45,52,52,95,40,85,3,46,77,16,59,32,22,41,87,89,78,59,78,34,26,71,9,82,68,80,74,100,6,10,53,84,80,7,87,3,82,26,26,14,37,26,58,96,73,41,2,79,43,56,74,30,71,6,100,72,93,83,40,28,79,24]