import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static StringTokenizer st;
    public static int t, n, m, length;
    public static int[] prefixA, prefixB, selectedArr;
    public static ArrayList<Integer>[] sums = new ArrayList[2];

    // 모든 연속하는 부분수열의 합 구함.
    public static void getSums(int[] arr, int arrNum) {
        int arrLength = arr.length;
        for (int l = 1; l < arrLength; l++) {
            for (int start = 0; start < arrLength - l; start++) {
                sums[arrNum].add(arr[start + l] - arr[start]);
            }
        }
    }

    public static int bsl(int find) {
        int start = 0;
        int end = length;
        int idx = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midNum = sums[1].get(mid);
            if (midNum < find) {
                start = mid + 1;
            } else if (find < midNum) {
                end = mid - 1;
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
            int midNum = sums[1].get(mid);
            if (midNum < find) {
                start = mid + 1;
            } else if (find < midNum) {
                end = mid - 1;
            } else {
                idx = mid;
                start = mid + 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        prefixA = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefixA[i] = Integer.parseInt(st.nextToken()) + prefixA[i - 1];
        }
        m = Integer.parseInt(br.readLine());
        prefixB = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            prefixB[i] = Integer.parseInt(st.nextToken()) + prefixB[i - 1];
        }
        sums[0] = new ArrayList<>();
        sums[1] = new ArrayList<>();
        getSums(prefixA, 0);
        getSums(prefixB, 1);
        Collections.sort(sums[0]);
        Collections.sort(sums[1]);

        long ans = 0;
        length = sums[1].size() - 1;
        for (int f : sums[0]) {
            // 갯수 세기 위해서 왼쪽 끝, 오른쪽 끝 측정한 후 빼줌.
            int l = bsl(t - f);
            int r = bsr(t - f);
            if (l != -1 && r != -1) ans += r - l + 1;
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();

    }
}