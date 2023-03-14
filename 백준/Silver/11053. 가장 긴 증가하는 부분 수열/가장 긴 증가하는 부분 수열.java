import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] inputArr;
    public static int[] max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        inputArr = new int[n];
        max = new int[n + 1];
        max[0] = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        int lastidx = 0;
        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
            int idx = lastidx;
            while (inputArr[i] <= max[idx]) {
                idx--;
            }
            max[idx + 1] = inputArr[i];
            if (idx == lastidx)
                lastidx++;
        }
        System.out.println(lastidx);
        bw.flush();
        bw.close();
    }

}