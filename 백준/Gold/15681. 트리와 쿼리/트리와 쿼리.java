import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n, r, q;
    public static ArrayList<Integer>[] tree;
    public static int[] sz;

    public static void dfs(int cur, int prev) {

        for (int n : tree[cur]) {
            if (n != prev) {
                dfs(n, cur);
                // 재귀 끝나고 올라오면서 아래 서브트리의 갯수 더해줌.
                sz[cur] += sz[n];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        tree = new ArrayList[n + 1];
        sz = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
            sz[i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        dfs(r, 0);
        for (int i = 0; i < q; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(sz[n] + "\n");
        }
        bw.flush();
        bw.close();
    }
}