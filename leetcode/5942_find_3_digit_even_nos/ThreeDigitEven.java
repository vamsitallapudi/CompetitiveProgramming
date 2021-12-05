import java.util.ArrayList;
import java.util.List;

public class ThreeDigitEven {
    List<Integer> result;

    public int[] findEvenNumbers(int[] digits) {
        int[] ans = new int[digits.length * digits.length];
        result = new ArrayList<>();
        result.add(1);
        result.add(2);
        result.add(3);
        permute(digits, 0, digits.length - 1);
        result.toArray(ans);
        return ans;
    }

    private void permute(int[] vals, int l, int r) {
    }

    private String concatenate(int[] val) {
        String value = "";
        for (int i : val) {
            value = value + i;
        }
        return value;
    }

    public static void main(String[] args) {
        ThreeDigitEven sol = new ThreeDigitEven();
        int[] ans = sol.findEvenNumbers(new int[] { 1, 2, 3, 0 });
        for (int i : ans) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
