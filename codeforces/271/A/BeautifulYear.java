import java.util.Scanner;

public class BeautifulYear {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            for(int i = n+1; i <= 10000; i++) {
                if (Integer.toString(i).chars().distinct().count() == 4) {
                    System.out.println(i);
                    return;  // No need for sc.close()
                }
            }
        }
    }
}