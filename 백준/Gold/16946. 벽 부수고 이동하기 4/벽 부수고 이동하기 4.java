import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static int cnt = 1;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[][] dp;
    public static int[][] connected;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, -1, 0, 1};

    public static class Pos {
        public int row;
        public int col;

        Pos(int r, int c) {
            row = r;
            col = c;
        }
    }

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }

    public static void move(Pos c, int cnt) {
        if (dp[c.row][c.col] != 0) return;
        // 방문 해야하는 길
        ArrayDeque<Pos> togo = new ArrayDeque<>();
        // 갔던 길 저장.
        ArrayDeque<Pos> went = new ArrayDeque<>();
        togo.add(c);
        visited[c.row][c.col] = true;
        while (!togo.isEmpty()) {
            Pos cur = togo.poll();
            went.add(cur);
            for (int dir = 0; dir < 4; dir++) {
                int nextR = cur.row + dr[dir];
                int nextC = cur.col + dc[dir];
                // 범위 안에 있고, 방문하지 않았고, 갈 수 있는 곳이면 가 본뒤 최댓값 저장.
                if (inRange(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] == 0) {
                    visited[nextR][nextC] = true;
                    togo.add(new Pos(nextR, nextC));
                }
            }
        }
        int num = went.size();
        while (!went.isEmpty()) {
            Pos cur = went.poll();
            dp[cur.row][cur.col] = num;
            // 같은 범위로 묶인 공간인지 체크하기 위함.
            connected[cur.row][cur.col] = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        dp = new int[n][m];
        connected = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        //모든 빈칸에 대해서 갈 수 있는 최댓값 저장.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) move(new Pos(i, j), cnt++);
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    // 원래 있던 자리  : + 1
                    int sum = 1;
                    for (int dir = 0; dir < 4; dir++) {
                        int nextR = i + dr[dir];
                        int nextC = j + dc[dir];
                        if (inRange(nextR, nextC) && !arr.contains(connected[nextR][nextC])) {
                            sum += dp[nextR][nextC];
                            arr.add(connected[nextR][nextC]);
                        }
                    }
                    map[i][j] = sum % 10;
                    arr.clear();
                }
                bw.write(map[i][j] + "");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}