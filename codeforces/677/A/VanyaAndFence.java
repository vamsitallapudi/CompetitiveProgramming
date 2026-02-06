
import java.util.Scanner;


public class VanyaAndFence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // new change
        int n = sc.nextInt();
        int h = sc.nextInt();
        int width = 0;
        while(n-- > 0) {
            int i = sc.nextInt();
            if(i>h) {
                width+=2;
            } else {
                width++;
            }
        }
        System.out.println(width);
        sc.close();
    }
}
