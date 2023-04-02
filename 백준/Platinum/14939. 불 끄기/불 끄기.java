import java.io.*;

public class Main {
    public static int n;
    public static int min = Integer.MAX_VALUE;
    public static boolean[][] copy;
    public static boolean[][] switches;

    public static void turn(int row, int col) {
        // 십자 스위치 바꿔줌.
        for (int i = -1; i <= 1; i++) {
            switches[row][col + i] = !switches[row][col + i];
        }
        switches[row - 1][col] = !switches[row - 1][col];
        switches[row + 1][col] = !switches[row + 1][col];
    }

    public static int check(int cnt) {

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (switches[i][j]) {
                    turn(i + 1, j);
                    cnt++;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (switches[i][j])
                    return Integer.MAX_VALUE;
            }
        }
        return cnt;
    }

    // 스위치를 누르면 해당 윗 스위치는 다시 상태가 바뀌지 않음.
    // => 아래 스위치는 재귀를 돌 필요 없음.
    public static void dfs(int row, int col, int cnt) {
        // 재귀 종료 조건. 두 번째 줄 부터
        if (col == n + 1) {
            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    copy[i][j] = switches[i][j];
                }
            }
            min = Math.min(min, check(cnt));
            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    switches[i][j] = copy[i][j];
                }
            }
            return;
        }

        // 스위치 누른 경우
        turn(row, col);
        dfs(row, col + 1, cnt + 1);
        // 누르지 않은 경우
        turn(row, col);
        dfs(row, col + 1, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = 10;
        switches = new boolean[n + 2][n + 2];
        copy = new boolean[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= n; j++) {
                char status = input.charAt(j - 1);
                copy[i][j] = status == 'O';
                switches[i][j] = copy[i][j];
            }
        }
        dfs(1, 1, 0);
        if (min == Integer.MAX_VALUE) min = -1;
        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }
}