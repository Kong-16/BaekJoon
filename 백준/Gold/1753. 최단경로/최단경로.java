import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int v, e, k;
    public static int MAX = Integer.MAX_VALUE;
    public static int[] dist;
    public static ArrayList<Edge>[] graph;

    public static class Edge implements Comparable<Edge> {
        public int from;
        public int to;
        public int weight;

        public Edge(int f, int t, int w) {
            from = f;
            to = t;
            weight = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Arrays.fill(dist, MAX);
        dist[start] = 0;
        pq.add(new Edge(start, start, 0));
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            for (Edge i : graph[e.to]) {
                if (e.weight + i.weight < dist[i.to]) {
                    dist[i.to] = e.weight + i.weight;
                    pq.add(new Edge(i.from, i.to, dist[i.to]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        graph = new ArrayList[v + 1];
        dist = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[f].add(new Edge(f, t, w));
        }
        dijkstra(k);
        for (int i = 1; i <= v; i++) {
            if (dist[i] == MAX) bw.write("INF\n");
            else bw.write(dist[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}