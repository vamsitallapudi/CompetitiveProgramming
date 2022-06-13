import java.util.HashSet;
import java.util.Set;

public class Solution {
    public long distinctNames(String[] ideas) {

        Set<String> set = new HashSet<>();
        int n = ideas.length;
        long sol = 0;
        for (String i : ideas) {
            set.add(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String a = ideas[i];
                String b = ideas[j];
                StringBuilder sa = new StringBuilder(a);
                StringBuilder sb = new StringBuilder(b);
                String fa = sa.replace(0, 1, "" + b.charAt(0)).toString();
                String fb = sb.replace(0, 1, "" + a.charAt(0)).toString();
                if (!set.contains(fa) && !set.contains(fb)) {
                    sol++;
                }
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        String a = "coffee";
        String b = "donuts";
        StringBuilder sa = new StringBuilder(a);
        StringBuilder sb = new StringBuilder(b);
        String f = sa.replace(0, 1, "" + b.charAt(0)).toString();
        System.out.println(f);

    }
}
