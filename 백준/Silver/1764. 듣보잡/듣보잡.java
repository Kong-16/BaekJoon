import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] noListen = new String[n];
        ArrayList<String> noListenAndSee = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            noListen[i] = br.readLine();
        }
        Arrays.sort(noListen);
        for (int i = 0; i < m; i++) {
            int idx = Arrays.binarySearch(noListen, br.readLine());
            if (-1 < idx)
                noListenAndSee.add(noListen[idx]);
        }
        noListenAndSee.sort(null);
        bw.write(noListenAndSee.size() + "\n");
        for (String s : noListenAndSee) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }
}