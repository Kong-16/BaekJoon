import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] max;
    public static int lastIdx;

    public static int binarySearch(int find) {
        int start = 0;
        int end = lastIdx;
        int idx = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (max[mid] < find) {
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
        n = Integer.parseInt(br.readLine());
        max = new int[n + 1];
        max[0] = Integer.MIN_VALUE;
        lastIdx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int idx = binarySearch(num);
            max[idx + 1] = num;
            if (idx == lastIdx) {
                lastIdx++;
            }
        }
        bw.write(lastIdx + "\n");
        bw.flush();
        bw.close();
    }
}