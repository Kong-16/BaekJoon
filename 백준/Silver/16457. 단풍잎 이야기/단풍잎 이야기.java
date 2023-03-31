import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static int k;
    public static int maxNum = Integer.MIN_VALUE;
    public static int skill;
    public static int[] quest;
    public static int[] skills;

    public static void dfs(int cur, int skill, int cnt) {
        if (cnt == n) {
            int questCnt = 0;
            for (int i = 0; i < m; i++) {
                if ((skill & quest[i]) == quest[i])
                    questCnt++;
                maxNum = Math.max(maxNum, questCnt);
            }
            return;
        }
        // 스킬은 2*n까지만 사용. 이 이상 가면 재귀 종료
        if (2 * n < cur) return;
        // cur번 스킬 포함한 경우
        dfs(cur + 1, skill | (1 << cur), cnt + 1);
        // 포함하지 않은 경우
        dfs(cur + 1, skill, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        // 비트 마스킹을 이용해 퀘스트가 포함되었는지 확인.
        skills = new int[(1 << n)];
        quest = new int[m];
        skill = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                int questNum = Integer.parseInt(st.nextToken());
                // 비트마스킹을 이용해 퀘스트 표시
                quest[i] = quest[i] | (1 << questNum);
            }
        }
        dfs(1, 0, 0);

        bw.write(maxNum + "\n");
        bw.flush();
        bw.close();

    }
}