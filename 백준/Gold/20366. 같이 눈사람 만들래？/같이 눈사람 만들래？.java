import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static int getMin(ArrayList<Integer> arr, int elza) {
        int s = 0;
        int e = arr.size() - 1;
        int minNum = Integer.MAX_VALUE;
        while (s < e) {
            int snow1 = arr.get(s);
            int snow2 = arr.get(e);
            int anna = snow1 + snow2;
            if (elza < anna)
                e--;
            else
                s++;
            minNum = Math.min(minNum, Math.abs(anna - elza));
        }
        return minNum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++)
            arr.add(Integer.parseInt(st.nextToken()));
        arr.sort(null);
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int snow1 = arr.get(i);
            arr.remove(i);
            for (int j = i + 1; j < n - 1; j++) {
                int snow2 = arr.get(j);
                int height = snow2 + snow1;
                arr.remove(j);
                minNum = Math.min(minNum, getMin(arr, height));
                arr.add(j, snow2);
            }
            arr.add(i, snow1);
        }

        bw.write(minNum + "\n");
        bw.flush();
        bw.close();
    }
}