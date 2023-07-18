package 第五章动态规划.背包问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 多重背包问题II {
    public static final int N = 2010;
    public static final int M = 50000;
    public static int[][] f = new int[N][N];
    public static int[] v = new int[M];
    public static int[] w = new int[M];
    public static int[] s = new int[M];
    public static int n, m;
    public static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        int idx = 1;
        for (int i = 1; i <= n; i ++ ) {
            String[] abc = reader.readLine().split(" ");
            a = Integer.parseInt(abc[0]);
            b = Integer.parseInt(abc[1]);
            c = Integer.parseInt(abc[2]);

            int all = b * c;
            int k = 1;
            while (k <= c) {
                v[idx] = a * k;
                w[idx] = b * k;
                c -= k;
                k *= 2;
                idx ++ ;
            }
            if (all > 0) {
                v[idx] = all * a;
                w[idx] = all * b;
                idx ++ ;
            }
        }

        for (int i = 1; i < idx; i ++ ) {
            for (int j = 0; j <= m; j ++ ) {
                f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                if (j >= v[i]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i]] + w[i]);
                }
            }
        }

        System.out.println(f[n][m]);
    }
}
