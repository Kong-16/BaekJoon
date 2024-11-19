import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dp = new int[d + 1];

        for (int i = 0; i < d + 1; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < d + 1; i++) {
            for (int j = 0; j < n; j++) {
                if (i == arr[j][1] && dp[arr[j][0]] + arr[j][2] < dp[i])
                    dp[i] = dp[arr[j][0]] + arr[j][2];
            }
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }
        bw.write(dp[d] + "\n");
        bw.flush();
        bw.close();
    }
}