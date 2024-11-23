import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            boolean[] arr = new boolean[50];
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 6; j++) {
                    arr[Integer.parseInt(st.nextToken())] = true;
                }
            }
            boolean flag = true;
            for (int i = 1; i < 50; i++) {
                if (!arr[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                bw.write("Yes\n");
            else
                bw.write("No\n");
        }
        bw.flush();
        bw.close();

    }
}