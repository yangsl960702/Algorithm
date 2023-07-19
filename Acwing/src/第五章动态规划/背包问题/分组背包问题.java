package 第五章动态规划.背包问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 01背包是分组背包的特殊情况而已，即第i组物品只有一个，所以没有第三层循环
 * 01背包 第i组物品中x个物品中选一个/零个  X = 1
 * 分组背包 第i组物品中的X个物品中选一个/零个 X >= 1
 * 所以以后直接将01记录为分组即可
 */
public class 分组背包问题 {
    public static final int N = 110;
    public static int[][] f = new int[N][N];
    public static int[][] v = new int[N][N];
    public static int[][] w = new int[N][N];
    public static int[] s = new int[N];
    public static int n, m;
    public static int[] f1 = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        for (int i = 1; i <= n; i ++ ) {
            int a = Integer.parseInt(reader.readLine());
            int k = 1;
            s[i] = a;
            while (a -- > 0) {
                String[] vw = reader.readLine().split(" ");
                v[i][k] = Integer.parseInt(vw[0]);
                w[i][k] = Integer.parseInt(vw[1]);
                k ++ ;
            }
        }


        /**
         * 二维记录
         */
        /*for (int i = 1; i <= n; i ++ ) {
            for (int j = 0; j <= m; j ++ ) {
                for (int k = 0; k <= s[i]; k ++ ) {
                    if (j >= v[i][k]) f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i][k]] + w[i][k]);
                }
            }
        }
        System.out.println(f[n][m]);*/

        /**
         * 滚动数组二维降低为一维
         */
        for (int i = 1; i <= n; i ++ ) {
            for (int j = m; j >= 0; j -- ) {
                for (int k = 0; k <= s[i]; k ++ ) {
                    if (j >= v[i][k]) {
                        f1[j] = Math.max(f1[j], f1[j - v[i][k]] + w[i][k]);
                    }
                }
            }
        }
        System.out.println(f1[m]);
    }
}
