public class NoOfSubsequencesWithSumK {

    int[] a;
    int k;

    public int printNoOfSubsequencesWithSumK(int[] a, int k) {
        this.a = a;
        this.k = k;
        return recHelper(0, 0);
    }

    private int recHelper(int i, int currSum) {
        if (i == a.length) {
            if (currSum == k) {
                return 1;
            }
            return 0;
        }
        return recHelper(i + 1, currSum + a[i]) + recHelper(i + 1, currSum);
    }

    public static void main(String[] args) {
        System.out
                .println(new NoOfSubsequencesWithSumK().printNoOfSubsequencesWithSumK(new int[] { 1, 2, 1, 2, 1 }, 2));
    }
}
