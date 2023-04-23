import java.io.*;
import java.util.ArrayList;

public class Main {
    public static int n, cnt;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }

    // 이어져 있는 집을 모두 방문
    public static void dfs(int curR, int curC) {
        // 집 갯수 세기
        cnt++;
        visited[curR][curC] = true;
        for (int dir = 0; dir < 4; dir++) {
            int nextR = curR + dr[dir];
            int nextC = curC + dc[dir];
            if (inRange(nextR, nextC) && !visited[nextR][nextC]) {
                dfs(nextR, nextC);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        ArrayList<Integer> village = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
                // 집이 없는 곳 방문처리.
                visited[i][j] = map[i][j] == 1 ? false : true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 새로운 단지를 만나면 dfs 돌림.
                if (!visited[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    village.add(cnt);
                }
            }
        }
        // 오름차순 정렬
        village.sort(null);
        bw.write(village.size() + "\n");
        for (int i = 0; i < village.size(); i++) {
            bw.write(village.get(i) + "\n");
        }
        bw.flush();
        bw.close();
    }
}