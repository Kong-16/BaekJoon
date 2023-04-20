import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, from, to, ans;
    public static ArrayList<Integer>[] edges;
    public static boolean[] visited;

    public static void dfs(int cur, int cnt) {
        if (cur == to) {
            ans = Math.min(ans, cnt);
            return;
        }
        visited[cur] = true;
        for (int i : edges[cur]) {
            if (!visited[i] || i == to)
                dfs(i, cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        edges = new ArrayList[n];
        visited = new boolean[n];
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken()) - 1;
        to = Integer.parseInt(st.nextToken()) - 1;
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            edges[v1].add(v2);
            edges[v2].add(v1);
        }
        dfs(from, 0);
        ans = ans == Integer.MAX_VALUE ? -1 : ans;
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}