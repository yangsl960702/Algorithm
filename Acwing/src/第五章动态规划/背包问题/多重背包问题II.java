package 第五章动态规划.背包问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 总体概述：三重暴力逐一尝试的方法通过：
 * 将每个物品的数目进行拆分，然后变成简单的01背包问题
 * 任何一个数都可以拆分成 m = 2^0 + 2^1 + 2^2 + ... + 2^x + c
 */
public class 多重背包问题II {
    public static final int N = 2010;
    public static final int M = 23000;
    public static int[][] f = new int[M][N];
    public static int[] v = new int[M];
    public static int[] w = new int[M];
    public static int[] s = new int[M];
    public static int n, m;
    public static int a, b, c;
    public static int[] f1 = new int[N];

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

            int k = 1;
            while (k <= c) {
                v[idx] = a * k;
                w[idx] = b * k;
                c -= k;
                k *= 2;
                idx ++ ;
            }
            if (c != 0) {
                v[idx] = c * a;
                w[idx] = c * b;
                idx ++ ;
            }
        }

        /**
         * 二维01背包
         */
        /*for (int i = 1; i < idx; i ++ ) {
            for (int j = 0; j <= m; j ++ ) {
                f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                if (j >= v[i]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i]] + w[i]);
                }
            }
        }*/

        for (int i = 1; i < idx; i ++ ) {
            for (int j = m; j >= v[i]; j -- ) {
                f1[j] = Math.max(f1[j], f1[j - v[i]] + w[i]);
            }
        }
        System.out.println(f1[m]);
    }
}
