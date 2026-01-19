import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BitPlus {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        // Read input
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        while(n-- > 0) {
            String s = br.readLine();
            if (s.contains("+")) {
                ans++;
            } else {
                ans--;
            }
        }
        out.println(ans);
        out.close();
    }
}
