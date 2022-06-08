import java.util.Arrays;

public class ReversingArray {

    public void rec(int[] arr, int l) {
        int r = (arr.length - 1) - l;
        if (l >= r) {
            return;
        }
        // swap logic
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        rec(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        new ReversingArray().rec(arr, 0);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
