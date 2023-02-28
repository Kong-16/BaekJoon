import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int fact = 1;
        int ans = 0;
        while (5 <= n) {
            ans += n / 5;
            n /= 5;
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();

    }

}