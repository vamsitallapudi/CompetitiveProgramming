import java.math.BigInteger;

public class Solution {
    public int countHousePlacements(int n) {
        if (n == 1) {
            return 4;
        }
        int p = 1;
        int e = 1;
        int prevP, prevE;
        int sol;
        BigInteger res;

        for (int i = 2; i <= n; i++) {
            prevP = p;
            prevE = e;

            e = prevP + prevE;
            p = prevE;
        }
        sol = p + e;
        long val = sol * sol;
        res = BigInteger.valueOf(val);
        return res.intValue();
    }

    public static void main(String[] args) {

    }
}
