import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static int n = 5;
    public static HashMap<Integer, int[]> board = new HashMap<>();
    // public static ArrayList<int[]> selected = new ArrayList<>();
    public static int[][] selected = new int[n][n];

    public static int checkBingo() {
        int cnt = 0;
        int tot = 0;
        for (int i = 0; i < n; i++) {
            tot = 0;
            for (int j = 0; j < n; j++) {
                tot += selected[i][j];
            }
            if (tot == n)
                cnt++;
        }
        for (int i = 0; i < n; i++) {
            tot = 0;
            for (int j = 0; j < n; j++) {
                tot += selected[j][i];
            }
            if (tot == n)
                cnt++;
        }
        tot = 0;
        for (int i = 0; i < n; i++) {
            tot += selected[i][i];
            if (tot == n)
                cnt++;
        }
        tot = 0;
        for (int i = 0; i < n; i++) {
            tot += selected[i][n - i - 1];
            if (tot == n)
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        boolean success = false;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int[] pos = { i, j };
                board.put(Integer.parseInt(st.nextToken()), pos);
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int[] sel = board.get(Integer.parseInt(st.nextToken()));
                selected[sel[0]][sel[1]] = 1;
                if (!success && 2 < checkBingo()) {
                    bw.write(5 * i + j + 1 + "\n");
                    success = true;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}