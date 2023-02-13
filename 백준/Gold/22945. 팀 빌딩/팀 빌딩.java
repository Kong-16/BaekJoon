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
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int s = 0;
        int e = n - 1;

        int prev = arr[s] < arr[e] ? arr[s] : arr[e];
        int prevAbility = prev * (e - s - 1);
        while (e - s > 1) {
            if (arr[s] < arr[e]) {
                s++;
                if (prev < arr[s] && Math.min(arr[s], arr[e]) * (e - s - 1) > prevAbility) {
                    prev = arr[s] < arr[e] ? arr[s] : arr[e];
                    prevAbility = prev * (e - s - 1);
                }
            } else {
                e--;
                if (prev < arr[e] && Math.min(arr[s], arr[e]) * (e - s - 1) > prevAbility) {
                    prev = arr[s] < arr[e] ? arr[s] : arr[e];
                    prevAbility = prev * (e - s - 1);
                }
            }
        }

        bw.write(prevAbility + "\n");
        bw.flush();
        bw.close();
    }

}
