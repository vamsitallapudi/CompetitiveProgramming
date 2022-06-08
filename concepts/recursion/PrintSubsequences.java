import java.util.*;

public class PrintSubsequences {
    int[] arr;

    public void printSub(int[] arr) {
        this.arr = arr;
        recHelper(0, new ArrayList<>());
    }

    private void recHelper(int ind, List<Integer> sub) {
        if (ind == arr.length) {
            sub.stream().forEach(x -> System.out.print(x));
            System.out.println();
            System.out.println("*************************");
            return;
        }
        sub.add(arr[ind]);
        recHelper(ind + 1, sub); // Take
        sub.remove(sub.size() - 1);
        recHelper(ind + 1, sub); // No take
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };
        new PrintSubsequences().printSub(arr);
    }
}
