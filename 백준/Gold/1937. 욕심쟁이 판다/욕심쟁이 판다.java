import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[][] field;
    public static int[][] dp;
    public static boolean[][] visited;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};
    public static int min = -100000000;

    public static class Pos {
        public int row;
        public int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static boolean inRange(int row, int col) {
        return 0 <= row && row < n && 0 <= col && col < n;
    }

    public static int dfs(int curR, int curC) {
        // 이미 방문했던 곳이면 dp값 반환.
        if (visited[curR][curC]) return dp[curR][curC];
        for (int dir = 0; dir < 4; dir++) {
            int nextR = curR + dr[dir];
            int nextC = curC + dc[dir];
            // 갈 수 있는 곳으로 최대한 간 뒤 최댓 값 저장.
            if (inRange(nextR, nextC) && field[curR][curC] < field[nextR][nextC]) {
                dp[curR][curC] = Math.max(dp[curR][curC], dfs(nextR, nextC) + 1);
                visited[curR][curC] = true;
            }
        }
        return dp[curR][curC];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        field = new int[n][n];
        dp = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 최소 거리 1로 초기화.
            Arrays.fill(dp[i], 1);
            for (int j = 0; j < n; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 1;
        // 모든 자리에서 dfs 돌려봄.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}