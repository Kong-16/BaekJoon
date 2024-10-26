import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int as = Integer.parseInt(st.nextToken());
        int ae = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int bs = Integer.parseInt(st.nextToken());
        int be = Integer.parseInt(st.nextToken());

        ArrayList<Integer> cows = new ArrayList<>();
        ArrayList<Integer> org = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            cows.add(i);
            org.add(i);
        }

        int cnt = 0;
        boolean flag = false;
        for (int i = 0; i < k; i++) {
            Collections.reverse(cows.subList(as - 1, ae));
            Collections.reverse(cows.subList(bs - 1, be));
            if (org.equals(cows)) {
                cnt = i + 1;
                flag = true;
                break;
            }
        }
        if (flag) {
            k = k % cnt;
            cows = new ArrayList<>(org);
            for (int i = 0; i < k; i++) {
                Collections.reverse(cows.subList(as - 1, ae));
                Collections.reverse(cows.subList(bs - 1, be));
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(cows.get(i) + "\n");
        }
        bw.flush();
        bw.close();
    }
}