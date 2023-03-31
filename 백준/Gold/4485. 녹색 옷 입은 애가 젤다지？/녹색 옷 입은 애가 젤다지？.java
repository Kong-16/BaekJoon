import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static int t;
    public static int n;
    public static int max = 1000000;
    public static int[][] board;
    public static int[][] dp;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static class Pos {
        public int r;
        public int c;


        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return r == pos.r && c == pos.c;
        }
    }

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }

    public static void bfs() {
        ArrayDeque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(0, 0));
        while (!deque.isEmpty()) {
            Pos curPos = deque.poll();
            int curR = curPos.r;
            int curC = curPos.c;
            for (int i = 0; i < 4; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];
                if (inRange(nextR, nextC)) {
                    if (board[nextR][nextC] + dp[curR][curC] < dp[nextR][nextC]) {
                        Pos tmp = new Pos(nextR, nextC);
                        deque.add(tmp);
                        dp[nextR][nextC] = board[nextR][nextC] + dp[curR][curC];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int test_case = 1; ; test_case++) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            board = new int[n][n];
            dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = max;
                }
            }
            dp[0][0] = board[0][0];
            bfs();
            bw.write("Problem " + test_case + ": " + dp[n - 1][n - 1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}