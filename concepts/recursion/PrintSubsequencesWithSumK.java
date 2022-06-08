import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrintSubsequencesWithSumK {
    int k;
    int[] a;

    public void printSubsequenceWithSum(int k, int[] a) {
        this.k = k;
        this.a = a;
        recHelper(0, 0, new ArrayList<>());
    }

    private void recHelper(int i, int currSum, List<Integer> sub) {
        if (i == a.length) {
            if (k == currSum) {
                System.out.println(sub.stream().map(Object::toString).collect(Collectors.joining(" ")));
            }
            return;
        }
        sub.add(a[i]);
        currSum += a[i];
        recHelper(i + 1, currSum, sub);
        sub.remove(sub.size() - 1);
        currSum -= a[i];
        recHelper(i + 1, currSum, sub);
    }

    public static void main(String[] args) {
        new PrintSubsequencesWithSumK().printSubsequenceWithSum(2, new int[] { 1, 2, 1 });
    }
}
