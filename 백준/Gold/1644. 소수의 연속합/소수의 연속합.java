import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
    public static boolean[] arr;

    public static void getPrime(int n) {
        for (int i = 2; i <= n; i++) {
            if (!arr[i]) {
                int mul = 2;
                while (n >= i * mul) {
                    arr[mul * i] = true;
                    mul++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        arr = new boolean[n + 1];
        ArrayList<Integer> prefix = new ArrayList<>();
        prefix.add(0);
        getPrime(n);
        int it = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i] == false) {
                prefix.add(i + prefix.get(it++));
            }
        }
        int s = 0;
        int e = 1;
        int cnt = 0;
        while (e < prefix.size()) {
            int tmp = prefix.get(e) - prefix.get(s);
            if (tmp == n) {
                cnt++;
                e++;
            } else if (tmp > n)
                s++;
            else
                e++;
        }
        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
    }

}