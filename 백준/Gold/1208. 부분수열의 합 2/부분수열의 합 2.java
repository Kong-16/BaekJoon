import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n, s, length;
    public static long ans;
    public static int[] arr;
    public static ArrayList<Integer>[] sum = new ArrayList[2];

    public static void dfs(int cur, int end, int arrNum, int total) {
        if (cur == end) {
            // 한 쪽 배열에서 완성되면 다른 한 쪽 안봐도 됨.
            if (total == s) ans++;
            sum[arrNum].add(total);
            return;
        }
        dfs(cur + 1, end, arrNum, total + arr[cur]);
        dfs(cur + 1, end, arrNum, total);
    }

    public static int bsl(int find) {
        int start = 0;
        int end = length;
        int idx = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (sum[1].get(mid) < find) {
                start = mid + 1;
            } else {
                idx = mid;
                end = mid - 1;
            }
        }
        return idx;
    }

    public static int bsr(int find) {
        int start = 0;
        int end = length;
        int idx = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (sum[1].get(mid) <= find) {
                idx = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return idx;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        ans = 0;
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        sum[0] = new ArrayList<>();
        sum[1] = new ArrayList<>();
        // 2^40의 조합을 봐야하므로 오래걸림 => 반 반 나눠서 조합한 뒤 양 쪽의 합이 s되는 수 찾음.
        dfs(0, n / 2, 0, 0);
        dfs(n / 2, n, 1, 0);
        for (int i = 0; i < 2; i++) {
            //모두 선택하지 않은 경우는 제외해야 하므로 마지막 원소 (0) 제거
            sum[i].remove(sum[i].size() - 1);
            sum[i].sort(null);
        }
        length = sum[1].size() - 1;
        for (int f : sum[0]) {
            // 같은 숫자가 중복될 수 있으므로 시작지점, 끝지점을 찾아서 빼줌. => 갯수
            int l = bsl(s - f);
            int r = bsr(s - f);
            if (l != -1) ans += r - l + 1;
        }
        // 찾는 값이 0일 경우 모두 선택 안하는 경우를 앞, 뒷 배열에서 한 개씩 빼야함.
        if (s == 0) ans -= 2;
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}