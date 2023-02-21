import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int r;
    public static int c;
    public static boolean[][] field;
    public static int[] dx = { -1, 0, 1 };

    public static boolean inRange(int x) {
        return x < r && 0 <= x;
    }

    public static boolean move(int x, int y) {
        if (y == c - 1)
            return true;
        for (int dir = 0; dir < 3; dir++) {
            int nextX = x + dx[dir];
            if (inRange(nextX) && field[nextX][y + 1]) {
                field[nextX][y + 1] = false;
                if (move(nextX, y + 1))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        field = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                field[i][j] = (str.charAt(j) == '.' ? true : false);
            }
        }
        int ans = 0;
        for (int i = 0; i < r; i++) {
            ans += (move(i, 0) ? 1 : 0);
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

}
