import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());
        int[] prefix = new int[n + 1];
        st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= n; i++) {
            prefix[i] = Integer.parseInt(st.nextToken()) + prefix[i - 1];
        }
        int s = 0;
        int e = 1;
        int minLength = Integer.MAX_VALUE;
        while (e <= n) {
            if (prefix[e] - prefix[s] >= number) {
                minLength = Math.min(minLength, e - s);
                s++;
            } else {
                e++;
            }
        }
        if (minLength == Integer.MAX_VALUE)
            bw.write(0 + "\n");
        else
            bw.write(minLength + "\n");
        bw.flush();
        bw.close();

    }

}
