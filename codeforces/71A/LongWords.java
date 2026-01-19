import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LongWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        // Read input
        int n = Integer.parseInt(br.readLine());
        // Output
        while( n-- > 0) {
            String s = br.readLine();
            if(s.length()>10) {
                out.println("" + s.charAt(0) + (s.length()-2) + s.charAt(s.length()-1));
            } else {
                out.println(s);
            }
        }
        out.close();
    }
}
