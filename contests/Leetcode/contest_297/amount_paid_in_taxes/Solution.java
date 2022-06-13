public class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        int prev = 0;
        for (int[] i : brackets) {
            int u = i[0];
            int currSlab = u - prev;
            if (income < currSlab) {
                tax += income * ((double) i[1] / 100);
                break;
            } else {
                tax += (currSlab) * ((double) i[1] / 100);
                income -= (currSlab);
                prev = u;
            }
        }
        return tax;
    }

    public static void main(String[] args) {
        int[][] brackets = new int[3][2];
        brackets[0] = new int[] { 3, 50 };
        brackets[1] = new int[] { 7, 10 };
        brackets[2] = new int[] { 12, 25 };

        int income = 10;
        double ans = new Solution().calculateTax(brackets, income);
        System.out.println(ans);

    }
}
