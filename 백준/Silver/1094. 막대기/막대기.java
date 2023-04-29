import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());
        int a = 64;
        int cnt = 0;
        while (0 < x) {
            while (x < a) {
                a = a >> 1;
            }
            cnt++;
            x -= a;
        }
        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
    }
}