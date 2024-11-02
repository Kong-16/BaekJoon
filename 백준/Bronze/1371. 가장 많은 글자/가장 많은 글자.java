import java.io.*;

public class Main {
    public static int a = 'a';
    public static int z = 'z';

    public static void main(String[] args) throws IOException, Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] alp = new int[z - a + 1];
        int m = 0;
        while (true) {
            String s = br.readLine();
            if (s == null)
                break;
            int l = s.length();
            for (int i = 0; i < l; i++) {
                if (s.charAt(i) == ' ')
                    continue;
                if (m < ++alp[s.charAt(i) - a])
                    m = alp[s.charAt(i) - a];
            }
        }
        for (int i = 0; i < z - a + 1; i++) {
            if (alp[i] == m)
                bw.write(Character.toString(i + a) + "");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

}