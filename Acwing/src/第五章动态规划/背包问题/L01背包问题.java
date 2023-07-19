package 第五章动态规划.背包问题;


import java.util.Scanner;

/**
 * 状态计算涉及 i - 1 层，一维时即需要背包容量从后向前，避免出现放多次物品的情况，
 * 违反01背包原则
 *
 * 记忆化：
 * 状态转移涉及i - 1层 如有要防止连锁更新 一律从后向前
 * 状态转移仅涉及i层，就无需注意
 *
 * 所谓的连锁更新是：我在使用前一个值的时候这个值仍然是旧值，没有被更新
 * 如果从前向后，后一个值使用前一个值时，前一个值已经被更新过，违反了题目的要求，比如说：
 * 01中物品相当于被放了多次 线性DP数字三角形中相当于我累加的时候想使用上一层的旧值，实际上我使用
 * 这一行我更新过的值，旧造成违反了状态转移的过程
 */
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
