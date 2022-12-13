import java.util.*;

public class FarAway {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long ans = 0l;

            int n = sc.nextInt();
            long m = sc.nextLong();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            for (int i = 0; i < n; i++) {
                ans += Math.max(Math.abs(m - a[i]), Math.abs(1l - a[i]));
            }

            System.out.println(ans);
        }
    }
}
