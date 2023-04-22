import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, k;
    public static int MAX = 100000;
    public static boolean[] visited;
    public static int[] fee;
    public static ArrayList<Integer>[] edges;

    public static int dfs(int cur) {
        //이미 방문한 곳이면 친구비 정산 완료한 곳이므로 친구비 안내기.
        visited[cur] = true;
        int minimum = fee[cur];
        for (int i : edges[cur]) {
            if (!visited[i]) {
                // 가본 곳 중 가장 친구비 적은 곳 리턴.
                minimum = Math.min(minimum, dfs(i));
            }
        }
        return minimum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        edges = new ArrayList[n];
        fee = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fee[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            edges[v1].add(v2);
            edges[v2].add(v1);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                sum += dfs(i);
        }
        if (k < sum)
            bw.write("Oh no \n");
        else
            bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}