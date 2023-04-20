import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, cnt;
    public static boolean[] visited;
    public static ArrayList<Integer>[] edges;

    public static void dfs(int cur) {

        // 갈 수 있는 곳 다 감 => 예외처리 없음.
        visited[cur] = true;
        for (int i : edges[cur]) {
            if (!visited[i]) {
                // 1번 컴퓨터는 빼는 예외처리 피하기 위해 dfs진입 시 가 아닌 for문 안에 넣음.
                cnt++;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        edges = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            edges[v1].add(v2);
            edges[v2].add(v1);
        }
        dfs(0);

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();

    }
}