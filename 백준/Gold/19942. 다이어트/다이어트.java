import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static boolean selected[];
    public static int[] bound;
    public static int[] total;
    public static int[][] arr;
    public static ArrayList<String> ansArr = new ArrayList<>();
    public static int ans = Integer.MAX_VALUE;

    public static void dfs(int depth) {
        if (depth == n) {
            total = new int[4];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (selected[i]) {
                    sum += arr[i][4];
                    // 영양정보의 합 저장.
                    for (int j = 0; j < 4; j++) {
                        total[j] += arr[i][j];
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                // 최소 영양정보 보다 작으면 종료.
                if (total[i] < bound[i])
                    return;
            }
            if (sum < ans) {
                ans = sum;
                // ansArr 초기화. 정답의 배열 담음.
                ansArr.clear();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (selected[i]) {
                        sb.append((i + 1) + " ");
                    }
                }
                // 사전 순 출력을 위해 정답 배열에 넣음. 이후 sort후 출력
                ansArr.add(sb.toString());
            } else if (sum == ans) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (selected[i]) {
                        sb.append((i + 1) + " ");
                    }
                }
                // 사전 순 출력을 위해 정답 배열에 넣음. 이후 sort후 출력
                ansArr.add(sb.toString());
            }
            return;
        }
        // 선택 하기, 안하기
        selected[depth] = true;
        dfs(depth + 1);
        selected[depth] = false;
        dfs(depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n][5];
        bound = new int[4];
        total = new int[4];
        selected = new boolean[n];
        for (int i = 0; i < 4; i++) {
            bound[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);

        ansArr.sort(null);
        if (ans != Integer.MAX_VALUE) {
            bw.write(ans + "\n");
            bw.write(ansArr.get(0));
        } else {
            bw.write(-1 + " ");
        }

        bw.write("\n");
        bw.flush();
        bw.close();
    }
}