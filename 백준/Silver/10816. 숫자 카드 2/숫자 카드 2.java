import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static int BSL(Integer[] arr, int f) {
        int start = 0;
        int end = arr.length - 1;
        int idx = -1;
        boolean found = false;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < f) {
                start = mid + 1;
            } else {
                found = true;
                idx = mid;
                end = mid - 1;
            }
        }
        if (found)
            return idx;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        Collections.sort(list);
        Integer[] arr = list.toArray(new Integer[0]);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        // System.out.println(map.toString());
        for (int i = 0; i < m; i++) {
            int f = Integer.parseInt(st.nextToken());
            if (map.containsKey(f))
                bw.write(map.get(f) + " ");
            else
                bw.write("0 ");
        }
        bw.flush();
        bw.close();
    }

}