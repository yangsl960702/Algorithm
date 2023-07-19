package 第五章动态规划.线性DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 最长上升子序列 - f[x] 以x为结尾时候的上升子序列的集合  属性： MAX
 * 纯暴力做法：和x前面的每一位进行比较，如果大于则更新当前值
 */
public class 最长上升子序列I {
    public static final int N = 1010;
    public static int[] g = new int[N];
    public static int[] f = new int[N];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        String[] arg = reader.readLine().split(" ");
        for (int i = 1; i <= arg.length; i ++ ) {
            g[i] = Integer.parseInt(arg[i - 1]);
        }
        Arrays.fill(f, 1);

        for (int i = 2; i <= n; i ++ ) {
            for (int j = i - 1; j >= 1; j -- ) {
                if (g[i] > g[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i ++ ) res = Math.max(res, f[i]);
        System.out.println(res);
    }
}
