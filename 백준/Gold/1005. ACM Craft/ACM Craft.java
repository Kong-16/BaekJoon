import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class Vertex {
        public int from;
        public int to;
        public int weight;

        public Vertex(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= t; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            ArrayList<Vertex>[] graph = new ArrayList[n + 1];
            int[] totalWeight = new int[n + 1];
            for (int i = 0; i <= n; i++)
                graph[i] = new ArrayList<>();
            int[] weight = new int[n + 1];
            int[] parent = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
                totalWeight[i] = weight[i];
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                parent[y]++;
                graph[x].add(new Vertex(x, y, weight[x]));
            }

            int w = Integer.parseInt(br.readLine());
            ArrayDeque<Vertex> deque = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (parent[i] == 0)
                    deque.add(new Vertex(i, i, weight[i]));
            }

            while (!deque.isEmpty()) {
                Vertex cur = deque.poll();
                for (Vertex next : graph[cur.to]) {
                    if (--parent[next.to] == 0) {
                        deque.add(next);
                    }
                    // next.to 에 해당하는 건물을 짓기 위한 시간의 최댓값 갱신
                    totalWeight[next.to] = Math.max(totalWeight[next.to], weight[next.to] + totalWeight[cur.to]);
                }
            }
            bw.write(totalWeight[w] + "\n");
        }
        bw.flush();
        bw.close();
    }
}