import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] graph;
    public static boolean[] visited;
    public static Set<Integer> set, ans;

    public static int dfs(int cur) {
        if (visited[cur]) {
            return cur;
        }
        visited[cur] = true;
        int tmp = dfs(graph[cur]);
        set.add(cur);
        if (cur == tmp) {
            for (int i : set)
                ans.add(i);
        }
        return tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1];
        visited = new boolean[n + 1];
        ans = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= n; i++) {
            set = new HashSet<>();
            dfs(i);
        }
        bw.write(ans.size() + "\n");
        ArrayList<Integer> sortedAns = new ArrayList<>(ans);
        Collections.sort(sortedAns);
        for (int i : sortedAns) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();

    }
}