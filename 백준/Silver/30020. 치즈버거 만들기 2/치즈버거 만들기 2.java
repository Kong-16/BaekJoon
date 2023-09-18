import java.io.*;
import java.util.*;

// tip: each public class is put in its own file
public class Main {
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int patty = Integer.parseInt(st.nextToken());
        int cheese = Integer.parseInt(st.nextToken());
        int gap = patty - cheese;
        int pLeft = patty - 2 * gap;
        int cLeft = cheese - gap;
        if (0 <= pLeft && pLeft < patty) {
            bw.write("YES\n" + gap + "\n");
            for (int i = 0; i < gap - 1; i++) {
                bw.write("aba\n");
            }
            bw.write("a");
            for (int i = 0; i < cLeft + 1; i++) {
                bw.write("ba");
            }
            bw.write("\n");
        } else {
            bw.write("NO" + "\n");
        }
        bw.flush();
        bw.close();
    }
}