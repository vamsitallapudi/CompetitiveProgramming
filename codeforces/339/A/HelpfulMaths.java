
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HelpfulMaths {
    public static void main(String[] args) {
          try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            String ans = Arrays.stream(s.split("\\+")).mapToInt(Integer::parseInt)
            .sorted().mapToObj(String::valueOf).collect(Collectors.joining("+"));
            System.out.println(ans);
          }
    }
}
