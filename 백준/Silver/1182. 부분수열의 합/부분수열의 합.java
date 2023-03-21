import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int s;
    public static int[] arr;
    public static int ans = 0;

    public static void dfs(int cur, int total, int cnt) {
        if (cur == n) {
            // 모두 고르지 않은 경우 예외 처리
            if (total == s && 0 < cnt)
                ans++;

            return;
        }
        // arr[cur] 포함 한 경우
        dfs(cur + 1, total + arr[cur], cnt + 1);

        // arr[cur] 포함 안 한 경우
        dfs(cur + 1, total, cnt);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}