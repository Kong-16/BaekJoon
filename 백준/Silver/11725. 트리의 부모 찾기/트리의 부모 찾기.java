import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static ArrayList<Integer>[] tree;
    public static int[] parent;

    public static void dfs(int cur, int prev) {
        parent[cur] = prev;
        for (int n : tree[cur]) {
            if (n != prev) dfs(n, cur);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) tree[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            tree[r].add(l);
            tree[l].add(r);
        }
        dfs(1, 0);
        for (int i = 2; i <= n; i++) {
            bw.write(parent[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}