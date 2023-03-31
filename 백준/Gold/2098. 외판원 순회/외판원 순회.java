import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int max = 100000000;
    public static int n;
    public static int[][] weight;
    public static int[][] dp;
    public static int full;

    public static int dfs(int cur, int visit) {
        if (visit == full) {
            int goal = weight[cur][0];
            if (goal < max) {
                dp[cur][visit] = goal;
                return goal;
            } else {
                return max - 1;
            }
        }
        if (dp[cur][visit] < max)
            return dp[cur][visit];

        dp[cur][visit] = max - 1;
        for (int i = 0; i < n; i++) {
            int cmp = (1 << i);
            if ((cmp & visit) == 0 && weight[cur][i] < max) {
                dp[cur][visit] = Math.min(dp[cur][visit], dfs(i, cmp | visit) + weight[cur][i]);
            }
        }
        return dp[cur][visit];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        full = (1 << n) - 1;
        weight = new int[n][n];
        //dp[i][j] = i마을들을 방문한 뒤 j의 위치에서 출발한 마을로 돌아오는 비용
        dp = new int[n][full + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], max);
            for (int j = 0; j < n; j++) {
                int w = Integer.parseInt(st.nextToken());
                // 갈 수 없는 경우 최댓값 저장
                w = w == 0 ? max : w;
                weight[i][j] = w;
            }
        }
        dfs(0, 1);
        bw.write(dp[0][1] + "\n");
        bw.flush();
        bw.close();
    }
}