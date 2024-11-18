import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Long> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }
        list.sort(null);
        int s = 0;
        int e = n - 1;

        long ans = 0;
        if (n % 2 != 0)
            ans = list.get(e--);
        while (s <= e) {
            ans = Math.max(ans, list.get(s++) + list.get(e--));
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}