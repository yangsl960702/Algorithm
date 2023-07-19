package 第五章动态规划.背包问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**什么是线性DP
 * 线性DP是指递推方程存在一个线性的递推关系。可以是一维线性的、二维线性的、三维线性的、…。
 *
 * 此题是典型的一维线性DP，状态转移从左上角 和 右上角转移过来
 *
 * 二维降一维时候，也需要从后向前遍历列，否则会使得值发生了连锁更新，
 * 从而违反了状态转移的实际过程
 */
public class 数字三角形 {
    public static final int N = 510;
    public static int n;
    public static int[][] g = new int[N][N];
    public static int[][] f = new int[N][N];
    public static int[] f1 = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= n; i ++ ) {
            String[] row = reader.readLine().split(" ");
            for (int j = 1; j <= row.length; j ++ ) {
                g[i][j] = Integer.parseInt(row[j - 1]);
            }
        }

        /**
         * 二维状态表示
         */
        /*for (int i = 0; i <= n + 1; i ++ ) Arrays.fill(f[i], -1000000000);
        f[1][1] = g[1][1];
        for (int i = 2; i <= n; i ++ ) {
            for (int j = 1; j <= i; j ++ ) {
                f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + g[i][j]);
                f[i][j] = Math.max(f[i][j], f[i - 1][j] + g[i][j]);
            }
        }
       int res = -1000000000;
        for (int i = 1; i <= n; i ++ ) res = Math.max(res, f[n][i]);
        System.out.println(res);*/


        /**
         * 二维降为一维
         */
        Arrays.fill(f1, -1000000000);
        f1[1] = g[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                f1[j] = Math.max(f1[j], f1[j - 1]) + g[i][j];
            }
        }

        int res1 = -1000000000;
        for (int i = 1; i <= n; i++) res1 = Math.max(res1, f1[i]);
        System.out.println(res1);
    }
}
