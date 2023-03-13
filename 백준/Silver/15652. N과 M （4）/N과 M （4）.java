import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
    public static int n;
    public static int m;
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;

    public static void dfs(int depth, int start) {
        if (depth == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = arr[depth - 1]; i <= n; i++) {
            arr[depth] = i;
            dfs(depth + 1, start + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m + 1];
        arr[0] = 1;
        dfs(1, 1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}