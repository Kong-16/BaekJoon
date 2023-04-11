import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String inp1 = br.readLine();
        String inp2 = br.readLine();
        int[][] dp = new int[inp1.length() + 1][inp2.length() + 1];
        char[] s = new char[inp1.length() + 1];
        char[] p = new char[inp2.length() + 1];
        for (int i = 1; i <= inp1.length(); i++)
            s[i] = inp1.charAt(i - 1);
        for (int i = 1; i <= inp2.length(); i++)
            p[i] = inp2.charAt(i - 1);
        for (int i = 1; i <= inp1.length(); i++) {
            for (int j = 1; j <= inp2.length(); j++) {
                if (s[i] == p[j])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        bw.write(dp[inp1.length()][inp2.length()] + "\n");
        bw.flush();
        bw.close();
    }

}