package 第五章动态规划.线性DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 不要考虑a[i]变化了下一步a[i + 1]新的变化怎么考虑，这种考虑方式是错误的
 * 正确的思路：
 * 明确f[i][j]的具体含义： 将a[1-i] 变成 b[1-j]的所有操作集合，取最小值
 * 动态规划问题一般只需要考虑最后一步/倒数第二步的取法即可
 *
 * 明确f的含义后，进行状态转移的划分
 * 增加 --- 即 a[1 - i] 加一个字母后与 b[1 - j] 相等，即a需要补充一位才与b相等，此时需要满足
 * a[1-i] 与 b[1 - j - 1]相等
 *
 * 删除 --- 即 a[1 - i] 需要删除一个字母后才能和 b[1 - j]相等，此时需要满足
 * a[1 - i - 1] 与 b[1 - j]相等
 *
 * 改 --- 分为两种情况
 * a[i]与b[j]相等  --- 不需要操作
 * a[i]与b[j]不相等  --- 需要将a[i]变成b[j]，此时必然是
 * a[1 - i - 1] 与 b[1 - j - 1]已经相等，只需要判断是否需要进行操作来进行+1或者不+1
 *
 */
public class 最短编辑距离 {
    public static final int N = 1010;
    public static int[][] f = new int[N][N];
    public static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        String a = " " + scanner.next();
        m = scanner.nextInt();
        String b = " " + scanner.next();

        for (int i = 1; i < N; i ++ ) Arrays.fill(f[i], 1000000000);
        for (int i = 0; i < N; i ++ ) f[0][i] = i;
        for (int i = 0; i < N; i ++ ) f[i][0] = i;

        for (int i = 1; i <= n; i ++ ) {
            for (int j = 1; j <= m; j ++ ) {
                f[i][j] = Math.min(f[i][j - 1] + 1, f[i - 1][j] + 1);
                if (a.charAt(i) != b.charAt(j)) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
                }else f[i][j] = Math.min(f[i - 1][j - 1], f[i][j]);
            }
        }
        System.out.println(f[n][m]);
    }
}
