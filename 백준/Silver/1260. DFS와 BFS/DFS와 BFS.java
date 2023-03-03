import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static class Vertex {
        public int from;
        public int to;

        Vertex(int f, int t) {
            from = f;
            to = t;
        }
    }

    public static int n;
    public static int m;
    public static boolean[] visited;
    public static Vertex[] graph;
    public static HashMap<Integer, Integer> map;
    public static StringBuilder dfsString = new StringBuilder();
    public static StringBuilder bfsString = new StringBuilder();

    public static void dfs(int v) {
        visited[v] = true;
        dfsString.append(v + " ");
        for (int i = 0; i < 2 * m; i++) {
            if (graph[i].from == v && !visited[graph[i].to]) {
                dfs(graph[i].to);
            }
        }
        return;
    }

    public static void bfs(int v) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited = new boolean[n + 1];
        visited[v] = true;
        queue.add(v);
        bfsString.append(v + " ");
        while (!queue.isEmpty()) {
            int start = queue.poll();
            for (int i = 0; i < 2 * m; i++) {
                if (graph[i].from == start && !visited[graph[i].to]) {
                    visited[graph[i].to] = true;
                    bfsString.append(graph[i].to + " ");
                    queue.add(graph[i].to);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        graph = new Vertex[2 * m];
        map = new HashMap<>();
        for (int i = 0; i < 2 * m; i += 2) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[i] = new Vertex(f, t);
            graph[i + 1] = new Vertex(t, f);
        }
        Arrays.sort(graph, (a, b) -> a.to - b.to);
        dfs(v);
        bfs(v);

        bw.write(dfsString + "\n");
        bw.write(bfsString + "\n");
        bw.flush();
        bw.close();
    }

}