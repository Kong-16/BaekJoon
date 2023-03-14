import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] input;
    public static int[] max;

    // 수열의 모든 수에 대해, 해당 수(x) 를 리스트 max의 가장 마지막 숫자부터 비교.
    // max[i] < x 인 i 위치 찾음. max[i+1] = x 해줌
    // => x가 최댓값인 부분수열의 길이가 i임. => 최대 길이의 최솟값 갱신가능.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        max = new int[n + 1];
        max[0] = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        int lastidx = 0;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            int idx = lastidx;
            while (input <= max[idx]) {
                idx--;
            }
            max[idx + 1] = input;
            if (idx == lastidx)
                lastidx++;
        }
        System.out.println(lastidx);
        bw.flush();
        bw.close();
    }

}