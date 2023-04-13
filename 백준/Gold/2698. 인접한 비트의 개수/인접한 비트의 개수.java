import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        // dp[i][j][0] : i길이 순열로 j 만들기 + 0으로 끝남
        // dp[i][j][1] : i길이 순열로 j 만들기 + 1로 끝남
        int[][][] dp = new int[101][101][2];
        int max = 100;
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        for (int i = 2; i <= max; i++) {
            dp[i][0][0] = dp[i - 1][0][1] + dp[i - 1][0][0];
            dp[i][0][1] = dp[i - 1][0][0];
        }
        for (int i = 2; i <= max; i++) {
            for (int j = 1; j <= i - 1; j++) {
                // i-1 로 j 만든 다음에 0 오기 + i-1 로 j 만든 다음에 1 오기
                dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                // i-1 로 j-1 만든 다음에 1 오기 + i-1로 j만든 다음에 0 오기
                dp[i][j][1] = dp[i - 1][j - 1][1] + dp[i - 1][j][0];
            }
        }


        for (int test_case = 1; test_case <= t; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            bw.write((dp[n][k][0] + dp[n][k][1]) + "\n");
        }


        bw.flush();
        bw.close();
    }
}