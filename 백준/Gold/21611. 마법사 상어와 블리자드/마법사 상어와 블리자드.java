import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static int r;
    public static int sharkPos;
    public static int[] destroyed = new int[4];
    public static int[][] field;
    public static Deque<Integer> bids;
    public static int[] dxIce = { 0, -1, 1, 0, 0 };
    public static int[] dyIce = { 0, 0, 0, -1, 1 };
    public static int[] dxBid = { 0, 1, 0, -1 };
    public static int[] dyBid = { -1, 0, 1, 0 };

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void field2Bids() {
        bids.clear();
        int x = sharkPos;
        int y = sharkPos;
        boolean[][] visited = new boolean[n][n];
        visited[x][y] = true;
        int dir = 0;
        while (x + y != 0) {
            x = (x + dxBid[dir] + 50 * n) % n;
            y = (y + dyBid[dir] + 50 * n) % n;

            if (field[x][y] > 0)
                bids.add(field[x][y]);
            visited[x][y] = true;
            int nextX = (x + dxBid[(dir + 1) % 4] + 50 * n) % n;
            int nextY = (y + dyBid[(dir + 1) % 4] + 50 * n) % n;
            if (!visited[nextX][nextY]) {
                dir = (dir + 1) % 4;
            }
        }
    }

    public static void bids2Field() {
        int x = sharkPos;
        int y = sharkPos;
        boolean[][] visited = new boolean[n][n];
        visited[x][y] = true;
        Deque<Integer> tmp = new ArrayDeque<>();
        int dir = 0;
        while (x + y != 0) {
            x = (x + dxBid[dir] + 50 * n) % n;
            y = (y + dyBid[dir] + 50 * n) % n;
            if (!bids.isEmpty()) {
                field[x][y] = bids.peek();
                tmp.add(bids.poll());
            } else
                field[x][y] = 0;
            visited[x][y] = true;
            int nextX = (x + dxBid[(dir + 1) % 4] + 50 * n) % n;
            int nextY = (y + dyBid[(dir + 1) % 4] + 50 * n) % n;
            if (!visited[nextX][nextY]) {
                dir = (dir + 1) % 4;
            }
        }
        bids = tmp;
    }

    public static void throwIce(int dir, int s) {
        int x = sharkPos;
        int y = sharkPos;
        for (int i = 0; i < s; i++) {
            x = (x + dxIce[dir] + 50 * n) % n;
            y = (y + dyIce[dir] + 50 * n) % n;
            if (inRange(x, y)) {
                field[x][y] = 0;
            }
        }
        field2Bids();
        bids2Field();
    }

    public static boolean explodeBids() {
        if (bids.isEmpty())
            return false;
        boolean isExplode = false;
        int numEqual = bids.poll();
        int count = 1;
        int num = 0;
        Deque<Integer> tmp = new ArrayDeque<>();

        while (!bids.isEmpty()) {
            num = bids.poll();
            if (num == numEqual)
                count++;
            else {
                if (count < 4)
                    for (int i = 0; i < count; i++) {
                        tmp.add(numEqual);
                    }
                else {
                    destroyed[numEqual] += count;
                    isExplode = true;
                }
                numEqual = num;
                count = 1;
            }
        }
        if (count < 4)
            for (int i = 0; i < count; i++) {
                tmp.add(numEqual);
            }
        else {
            destroyed[numEqual] += count;
            isExplode = true;
        }
        bids = tmp;
        bids2Field();
        return isExplode;
    }

    public static void splitBids() {
        if (bids.isEmpty())
            return;
        Deque<Integer> tmp = new ArrayDeque<>();
        int numEqual = bids.poll();
        int count = 1;
        while (!bids.isEmpty()) {
            int num = bids.poll();
            if (num == numEqual)
                count++;
            else {
                tmp.add(count);
                tmp.add(numEqual);
                numEqual = num;
                count = 1;
            }
        }
        tmp.add(count);
        tmp.add(numEqual);
        bids = tmp;
        bids2Field();
    }

    public static void blizzard(int dir, int s) {
        throwIce(dir, s);
        for (;;) {
            if (!explodeBids())
                break;
        }
        splitBids();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        field = new int[n][n];
        bids = new ArrayDeque<>();
        sharkPos = n / 2;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        field2Bids();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            blizzard(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int ans = 0;
        for (int i = 1; i <= 3; i++) {
            ans += i * destroyed[i];
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
