import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static int MAX = 100000;
    public static int[][] map, dp;
    public static boolean[][] visited;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }

    public static class Pos {
        public int r;
        public int c;
        public int wall;

        public Pos(int r, int c, int wall) {
            this.r = r;
            this.c = c;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        // 뚫은 벽의 갯수 저장.
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
                dp[i][j] = MAX;
            }
        }
        dp[0][0] = 0;
        ArrayDeque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(0, 0, 0));
        while (!deque.isEmpty()) {
            Pos cur = deque.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nextR = cur.r + dr[dir];
                int nextC = cur.c + dc[dir];
                if (inRange(nextR, nextC)) {
                    // 벽이 아닐 경우엔 그냥 감.
                    if (map[nextR][nextC] == 0 && cur.wall < dp[nextR][nextC]) {
                        dp[nextR][nextC] = cur.wall;
                        deque.add(new Pos(nextR, nextC, cur.wall));
                    }
                    //이미 간 길이어도 벽을 덜 뚫고 지나갈 수 있으면 감.
                    else if (map[nextR][nextC] == 1 && cur.wall + 1 < dp[nextR][nextC]) {
                        dp[nextR][nextC] = cur.wall + 1;
                        deque.add(new Pos(nextR, nextC, cur.wall + 1));
                    }
                }
            }
        }
        bw.write(dp[n - 1][m - 1] + "\n");
        bw.flush();
        bw.close();

    }
}