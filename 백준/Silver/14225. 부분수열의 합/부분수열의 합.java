import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] arr;
    public static HashSet<Integer> sum = new HashSet<>();

    public static void dfs(int depth, int total, int cnt) {
        if (depth == n) {
            if (0 < cnt) {
                // 1개 이상 선택 시 sum에 추가.
                // cnt안넣고 sum에 0 넣어도 됨.
                sum.add(total);
            }
            return;
        }
        // 선택 한 경우
        dfs(depth + 1, total + arr[depth], cnt + 1);
        // 하지 않은 경우
        dfs(depth + 1, total, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0);
        int idx = 0;
        int ans = 1;
        while (sum.contains(ans)) {
            ans++;
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();

    }

}