import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int r;
    public static int c;
    public static int ans = 0;
    public static int count = 0;

    public static boolean[] alphabet;
    public static boolean[][] visited;
    public static char[][] field;

    public static int[] dx = { 0, 1, 0, -1 };
    public static int[] dy = { 1, 0, -1, 0 };

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < r && 0 <= y && y < c;
    }

    public static boolean isPromising(int x, int y) {
        int idx = field[x][y] - '0' - 17;
        if (alphabet[idx] || visited[x][y])
            return false;

        return true;
    }

    public static int move(int x, int y, int count) {
        ans = Math.max(count, ans);
        for (int dir = 0; dir < 4; dir++) {
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];
            if (inRange(nextX, nextY) && isPromising(nextX, nextY)) {
                int idx = field[nextX][nextY] - '0' - 17;
                alphabet[idx] = true;
                visited[nextX][nextY] = true;
                count++;
                move(nextX, nextY, count);
                visited[nextX][nextY] = false;
                alphabet[idx] = false;
                count--;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        alphabet = new boolean[26];
        visited = new boolean[r][c];
        field = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                field[i][j] = str.charAt(j);
            }
        }
        alphabet[field[0][0] - '0' - 17] = true;
        visited[0][0] = true;
        bw.write(move(0, 0, 1) + "\n");
        bw.flush();
        bw.close();
    }
}
