package 第五章动态规划.线性DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 最短编辑距离的简单变形，就是变化完成后，比较一下是否满足变换次数，满足就进行记录
 */
public class 编辑距离 {
    public static final int N = 1010;
    public static String[] g = new String[N];
    public static int n, m;
    public static int[][] f = new int[N][N];
    public static Point[] p = new Point[N];
    public static int[] cnt = new int[N];

    //从b -> point.a
    public static boolean edit(Point point, String b) {
        String a = point.a;
        int w = point.b;

        int max = Math.max(a.length(), b.length());
        for (int i = 0; i <= max; i ++ ) Arrays.fill(f[i], 1000000000);
        for (int i = 0; i <= max; i ++ ) {
            f[i][0] = i;
            f[0][i] = i;
        }

        for (int i = 1; i < b.length(); i ++ ) {
            for (int j = 1; j < a.length(); j ++ ) {
                f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
                if (b.charAt(i) == a.charAt(j)) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                }else f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
            }
        }

        if (f[b.length() - 1][a.length() - 1] <= w) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        for (int i = 1; i <= n; i ++ ) {
            g[i] = " " + reader.readLine();
        }
        for (int i = 1; i <= m; i ++ ) {
            String[] ab = reader.readLine().split(" ");
            p[i] = new Point(" " + ab[0], Integer.parseInt(ab[1]));
        }

        for (int i = 1; i <= m; i ++ ) {
            int res = 0;
           for (int j = 1; j <= n; j ++ ) {
               if (edit(p[i], g[j])) {
                   res ++ ;
               }
           }
           cnt[i] = res;
        }

        for (int i = 1; i <= m; i ++ ) {
            System.out.println(cnt[i]);
        }
    }
}

class Point{
    String a;
    int b;
    public Point(String a, int b) {
        this.a = a;
        this.b = b;
    }
}
