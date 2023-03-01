import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static int n;
    public static int[] population;
    public static boolean[][] adjMatrix;
    public static boolean[] selected;
    public static int[] parent;
    public static int totalSum = 0;
    public static int popSum = 0;
    public static int minGap = Integer.MAX_VALUE;

    public static int find(int a) {
        if (parent[a] == a)
            return parent[a];
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot)
            return;
        parent[bRoot] = aRoot;
    }

    // 계산해도 되는지 체크.
    // 인접한 구역끼리 union-find 한 뒤, 구역 수 체크.
    // 구역이 2개이면 true, 아니면 false 리턴
    public static boolean check() {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j] && selected[i] == selected[j])
                    union(i, j);
            }
        }
        for (int i = 0; i < n; i++)
            find(i);
        int cnt = Arrays.stream(parent).boxed().collect(Collectors.toSet()).size();
        if (cnt != 2)
            return false;
        return true;
    }

    // 부분집합 dfs.
    // 0 ~ n-1까지 구역을 하나씩 포함하며 두 구역으로 나뉘며 이어져 있는지 계산.
    // 이어져있는 경우 인구의 차 구해서 최솟값 저장.
    public static void select(int s) {
        if (s == n) {
            if (check()) {
                int aSum = 0;
                int bSum = 0;
                for (int i = 0; i < n; i++) {
                    if (selected[i])
                        aSum += population[i];
                    else
                        bSum += population[i];
                }
                minGap = Math.min(minGap, Math.abs(aSum - bSum));

            }
            return;
        }

        selected[s] = true;
        select(s + 1);
        selected[s] = false;
        select(s + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        // n번 지역구의 인구수 저장.
        population = new int[n];

        // 부분집합을 만들기 위해 사용. true / false 로 지역구 나눔.
        selected = new boolean[n];
        // 지역구끼리 이어져있는지 확인하는 배열/
        adjMatrix = new boolean[n][n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            totalSum += population[i];
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int vNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j < vNum; j++) {
                adjMatrix[i][Integer.parseInt(st.nextToken()) - 1] = true;
            }
        }
        select(0);
        if (minGap == Integer.MAX_VALUE)
            bw.write(-1 + "\n");
        else
            bw.write(minGap + "\n");
        bw.flush();
        bw.close();
    }

}