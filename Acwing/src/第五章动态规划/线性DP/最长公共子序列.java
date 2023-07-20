package 第五章动态规划.线性DP;

import java.util.Scanner;

/**
 * 状态划分00 01 10 11
 * 划分不难，主要是第一次体现求最大值时，集合处于包含关系即可，即：
 * a 包含于 b， b 包含于 c，求a的最大值可以直接用b代替，从而将状态转移的一种状态代替
 */
public class 最长公共子序列 {
    public static int n, m;
    public static final int N = 1010;
    public static int[][] f = new int[N][N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        String a = " " + scanner.next();
        String b = " " + scanner.next();

        for (int i = 1; i <= n; i ++ ) {
            for (int j = 1; j <= m; j ++ ) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (a.charAt(i) == b.charAt(j)) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
