package 第五章动态规划.背包问题;

import sun.applet.Main;

import java.util.Scanner;

public class L01背包问题 {
    public static int n, m;
    public static final int N = 1010;
    public static int[] v = new int[N];
    public static int[] w = new int[N];
    public static int[][] f = new int[N][N];
    public static int[] f1 = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 1; i <= n; i ++ ) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            v[i] = a;
            w[i] = b;
        }


        /**
         * 01背包二维法
         */
        /*for (int i = 1; i <= n; i ++ ) {
            for (int j = 0; j <= m; j ++ ) {
                f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                if (j >= v[i]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        System.out.println(f[n][m]);*/

        /**
         * 01背包一维法
         */
        for (int i = n; i > 0; i -- ) {
            for (int j = m; j >= v[i]; j -- ) {
                f1[j] = Math.max(f1[j], f1[j - v[i]] + w[i]);
            }
        }
        System.out.println(f1[m]);

    }
}
