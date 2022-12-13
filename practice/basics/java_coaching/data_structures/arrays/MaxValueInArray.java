import java.util.*;

public class MaxValueInArray {
    public static void main(String[] args) {
        // 4
        // 1 2 3 4

        // to read the input from the user
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // size
        int[] arr = new int[n]; // initializing the array with dynamic size
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        // code to find maximum value in an array
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
