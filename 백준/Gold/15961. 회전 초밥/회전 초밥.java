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
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] table = new int[n];
        int[] sushi = new int[d + 1];
        int s = 0;
        int e;
        int cnt = 1;
        sushi[c] = 1;
        int maxCnt = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            table[i] = Integer.parseInt(bf.readLine());

        for (int i = 0; i < k; i++) {
            sushi[table[i]]++;
            if (sushi[table[i]] == 1)
                cnt++;
            maxCnt = Math.max(maxCnt, cnt);
        }
        for (e = k; e < n; e++) {
            sushi[table[e]]++;
            if (sushi[table[e]] == 1)
                cnt++;
            sushi[table[s]]--;
            if (sushi[table[s++]] == 0)
                cnt--;
            maxCnt = Math.max(maxCnt, cnt);
        }
        e = 0;
        for (; s < n; s++) {
            sushi[table[e]]++;
            if (sushi[table[e++]] == 1)
                cnt++;
            sushi[table[s]]--;
            if (sushi[table[s]] == 0)
                cnt--;
            maxCnt = Math.max(maxCnt, cnt);
        }
        bw.write(maxCnt + "\n");
        bw.flush();
        bw.close();
    }
}
