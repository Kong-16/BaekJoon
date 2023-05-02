import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dist = new int[200002];
        boolean[] visited = new boolean[200002];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(n);
        while (!deque.isEmpty()) {
            int pos = deque.pop();
            if (pos == m)
                break;

            int[] next = new int[]{pos - 1, pos + 1, pos * 2};
            for (int i : next) {
                if (0 <= i && i < 200002 && !visited[i]) {
                    visited[i] = true;
                    dist[i] = dist[pos] + 1;
                    deque.add(i);
                }
            }

        }
        bw.write(dist[m] + "\n");
        bw.flush();
        bw.close();

    }
}