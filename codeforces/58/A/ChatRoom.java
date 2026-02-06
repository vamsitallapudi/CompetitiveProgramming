
import java.util.Scanner;



public class ChatRoom {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            char[] s = sc.next().toCharArray();
            char[] t = "hello".toCharArray();
            int p = 0; // pointer
            int p1 = 0;
            while(p1 < s.length) {
                if(t[p] == s[p1]) {
                    p++;
                    if(p >= t.length) {
                        System.out.println("YES");
                        return;
                    }
                }
                p1++;
            }
            System.out.println("NO");

        }
    }
}
