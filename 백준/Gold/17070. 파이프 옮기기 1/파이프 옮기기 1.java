import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n + 1][n + 1];
        int[][][] pipe = new int[n + 1][n + 1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pipe[1][2][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i][j - 1] != 1) {
                    // 현재 칸 가로 = 왼쪽 옆 칸 가로 + 왼쪽 옆 칸 대각선
                    pipe[i][j][0] += pipe[i][j - 1][0] + pipe[i][j - 1][1];
                }
                if (board[i - 1][j] != 1) {
                    // 현재 칸 세로 = 위 칸 대각선 + 세로
                    pipe[i][j][2] += pipe[i - 1][j][1] + pipe[i - 1][j][2];
                }
                if (board[i - 1][j - 1] != 1 && board[i][j - 1] != 1 && board[i - 1][j] != 1) {
                    // 현재 칸 대각선 = 왼쪽 대각선 칸 가로 + 대각선 + 세로
                    pipe[i][j][1] += pipe[i - 1][j - 1][0] + pipe[i - 1][j - 1][1] + pipe[i - 1][j - 1][2];
                }
            }
        }

        int ans = pipe[n][n][0] + pipe[n][n][1] + pipe[n][n][2];
        if (board[n][n] == 1) {
            ans = 0;
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}