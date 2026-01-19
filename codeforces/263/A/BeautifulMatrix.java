
import java.util.Scanner;


public class BeautifulMatrix {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            for(int i = 0; i<5; i++) {
                for (int j = 0; j<5; j++) {
                    int val = sc.nextInt();
                    if(val == 1) {
                        int ans = Math.abs(i-2) + Math.abs(j-2);
                        System.out.println(ans);
                        return;
                    }
                }
            }
        }
    }
}
