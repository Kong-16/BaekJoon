import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    public static int n;
    public static int m;
    public static int r;

    public static int[][] arr;
    public static int[][] workSpace;

    public static void synchronize() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = workSpace[i][j];
            }
        }
    }

    public static void inverse() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                workSpace[n - 1 - i][j] = arr[i][j];
            }
        }
        synchronize();
    }

    public static void reverse() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                workSpace[i][m - 1 - j] = arr[i][j];
            }
        }
        synchronize();
    }

    public static void rotate90() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                workSpace[j][n - 1 - i] = arr[i][j];
            }
        }
        int tmp = n;
        n = m;
        m = tmp;
        synchronize();
    }

    public static void rotate270() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                workSpace[m - 1 - j][i] = arr[i][j];
            }
        }
        int tmp = n;
        n = m;
        m = tmp;
        synchronize();
    }

    public static void pushPartArr90() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < n / 2) {
                    if (j < m / 2) {
                        workSpace[i][j] = arr[i + n / 2][j];
                    } else {
                        workSpace[i][j] = arr[i][j - m / 2];
                    }
                } else if (j < m / 2) {
                    workSpace[i][j] = arr[i][j + m / 2];
                } else {
                    workSpace[i][j] = arr[i - n / 2][j];
                }
            }
        }
        synchronize();
    }

    public static void pushPartArr270() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < n / 2) {
                    if (j < m / 2) {
                        workSpace[i][j] = arr[i][j + m / 2];
                    } else {
                        workSpace[i][j] = arr[i + n / 2][j];
                    }
                } else if (j < m / 2) {
                    workSpace[i][j] = arr[i - n / 2][j];
                } else {
                    workSpace[i][j] = arr[i][j - m / 2];
                }
            }
        }
        synchronize();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int big = n > m ? n : m;
        arr = new int[big][big];
        workSpace = new int[big][big];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int t = 0; t < r; t++) {
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    inverse();
                    break;
                case 2:
                    reverse();
                    break;
                case 3:
                    rotate90();
                    break;
                case 4:
                    rotate270();
                    break;
                case 5:
                    pushPartArr90();
                    break;
                case 6:
                    pushPartArr270();
                    break;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.write("\n\n");
        bw.flush();
        bw.close();
    }
}