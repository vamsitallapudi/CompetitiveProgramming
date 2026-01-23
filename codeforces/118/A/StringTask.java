
import java.util.Scanner;
import java.util.stream.Collectors;


public class StringTask {
    public static void main(String[] args) {
        String vowels = "aeiouy";
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine().toLowerCase();
            String ans = s.chars().filter(c -> vowels.indexOf(c) == -1)
            .mapToObj(c -> "." + (char)c)
            .collect(Collectors.joining());
            System.out.println(ans);
        }
    }
}
