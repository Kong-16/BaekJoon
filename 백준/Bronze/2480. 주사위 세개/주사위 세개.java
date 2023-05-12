import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dice = new int[7];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) dice[Integer.parseInt(st.nextToken())]++;
        int ans = 0;
        for (int i = 1; i < 7; i++) {
            if (dice[i] == 3) {
                ans = 10000 + (i * 1000);
                break;
            } else if (dice[i] == 2) {
                ans = 1000 + (i * 100);
                break;
            } else if (dice[i] == 1) ans = i * 100;
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}