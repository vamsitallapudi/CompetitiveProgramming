
import java.util.Scanner;

public class Translation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        if(s.length() != t.length()) {
            System.out.println("NO");
            return;
        }
        char[] ca1 = s.toCharArray();
        char[] ca2 = t.toCharArray();
        for(int i = 0; i< s.length(); i++) {
            if(ca1[i] != ca2[s.length()-i-1]){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        sc.close();
    }
}
