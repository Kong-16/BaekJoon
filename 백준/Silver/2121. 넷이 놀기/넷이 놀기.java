import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static Pair[] pos;

    public static class Pair implements Comparable<Pair> {
        public int x;
        public int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair p) {
            if (this.x == p.x) {
                return this.y - p.y;
            }
            return this.x - p.x;
        }

        public boolean isEqual(Pair p) {
            return this.x == p.x && this.y == p.y;
        }
    }

    public static boolean find(Pair p) {
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (0 < pos[mid].compareTo(p)) {
                end = mid - 1;
            } else if (pos[mid].compareTo(p) < 0) {
                start = mid + 1;
            } else
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        pos = new Pair[n];
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pos[i] = new Pair(x, y);
        }
        Arrays.sort(pos);
        int ans = 0;
        for (Pair p : pos) {
            Pair one = new Pair(p.x + a, p.y);
            Pair two = new Pair(p.x, p.y + b);
            Pair three = new Pair(p.x + a, p.y + b);
            if (find(one) && find(two) && find(three))
                ans++;
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}