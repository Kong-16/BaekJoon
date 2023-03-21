import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int s;
    public static int[] sequence;
    public static int[] part;
    public static boolean[] selected;
    public static int ans = 0;

    public static void dfs(int depth) {
        if (depth == n) {
            int sum = 0;
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (selected[i]) {
                    flag = true;
                    sum += sequence[i];
                }
            }
            if (sum == s && flag)
                ans++;
            return;
        }
        selected[depth] = true;
        dfs(depth + 1);
        selected[depth] = false;
        dfs(depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        selected = new boolean[n];
        sequence = new int[n];
        part = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

}