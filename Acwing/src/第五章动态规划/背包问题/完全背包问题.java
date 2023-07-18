package 第五章动态规划.背包问题;

import java.util.Scanner;

public class 完全背包问题 {
    public static int n, m;
    public static final int N = 1010;
    public static int[] v = new int[N];
    public static int[] w = new  int[N];
    public static int[][] f = new int[N][N];
    public static int[][] ff = new int[N][N];
    public static int[] f1 =  new int[N];

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
         * 二维数组三重循环
         */
        /*for (int i = 1; i <= n; i ++ ) {
            for (int j = 0; j <= m; j ++ ) {
                for (int k = 0; k * v[i] <= j; k ++ ) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }
        System.out.println(f[n][m]);*/


        /**
         * 二维二重循环
         */
        /*for (int i = 1; i <= n; i ++ ) {
            for (int j = 0; j <= m; j ++ ) {
                ff[i][j] = Math.max(ff[i][j], ff[i - 1][j]);
                if (j >= v[i]) {
                    ff[i][j] = Math.max(ff[i][j], ff[i][j - v[i]] + w[i]);
                }
            }
        }
        System.out.println(ff[n][m]);*/


        /**
         * 通过滚动数组二维降为一维
         */
        for (int i = 1; i <= n; i ++ ) {
            for (int j = v[i]; j <= m; j ++ ) {
                f1[j] = Math.max(f1[j], f1[j - v[i]] + w[i]);
            }
        }
        System.out.println(f1[m]);
    }
}
