import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String inp1 = br.readLine();
        String inp2 = br.readLine();
        int a = inp1.length();
        int b = inp2.length();
        int[][] dp = new int[a + 1][b + 1];
        char[] s = new char[a + 1];
        char[] p = new char[b + 1];
        for (int i = 1; i <= a; i++)
            s[i] = inp1.charAt(i - 1);
        for (int i = 1; i <= b; i++)
            p[i] = inp2.charAt(i - 1);
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (s[i] == p[j])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        bw.write(dp[a][b] + "\n");

        Stack<Character> stack = new Stack<>();
        while (0 < a && 0 < b) {
            if (dp[a][b] == dp[a - 1][b]) a--;
            else if (dp[a][b] == dp[a][b - 1]) b--;
            else {
                stack.push(s[a]);
                a--;
                b--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop() + "");
        }
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
    }

}