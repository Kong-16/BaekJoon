import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            int[] arr = new int[n];
            int ans = -Integer.MIN_VALUE;
            arr[0] = Integer.parseInt(br.readLine());
            for (int i = 1; i < n; i++) {
                int number = Integer.parseInt(br.readLine());
                arr[i] = Math.max(number, arr[i - 1] + number);
                ans = Math.max(ans, arr[i]);
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
    }
}