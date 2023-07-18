package 第五章动态规划.背包问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 多重背包问题 {
    public static final int N = 110;
    public static int[] v = new int[N];
    public static int[] w = new int[N];
    public static int[] s = new int[N];
    public static int n, m;
    public static int a, b, c;
    public static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        for (int i = 1; i <= n; i ++ ) {
            String[] abc = reader.readLine().split(" ");
            a = Integer.parseInt(abc[0]);
            b = Integer.parseInt(abc[1]);
            c = Integer.parseInt(abc[2]);
            v[i] = a;
            w[i] = b;
            s[i] = c;
        }

        for (int i = 1; i <= n; i ++ ) {
            for (int j = 0; j <= m; j ++ ) {
                for (int k = 0; k <= s[i]; k ++ ) {
                    if (j >= k * v[i]) {
                        f[i][j] = Math.max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
                    }
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
