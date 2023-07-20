package 第五章动态规划.区间DP;

import java.util.Scanner;

/**
 * 区间合并的典型题
 * 三步骤：
 * 1.列举区间长度，直接从2开始枚举
 * 2.列举左端点(再根据区间长度确定右端点)
 * 3.取中间点更新值
 *
 * 注意：区间问题可以忽视区间长度为1时的情况，直接从2开始枚举
 * 注意题目的过程
 * l r l(min) + r(min) 这是左右合并最小代价 + 区间[l, r]的和，正是因为这一步不能一开始自己更新区间
 * 长度为1时的值，否则当区间长度为1的时候，会出现加了两次代价的情况，如果不加区间[l, r]又会出现长区间
 * 合并时候，没有加入旧的代价的情况，只是当前的代价情况
 *
 * 补充：具体问题具体分析，区间dp三步走的大步骤不会变，具体需要自己灵活分析
 */
public class 石子合并 {
    public static final int N = 310;
    public static int n;
    public static int[][] f = new int[N][N];
    public static int[] g = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 1; i <= n; i ++ ) {
            g[i] = g[i - 1] + scanner.nextInt();
        }

        for (int i = 2; i <= n; i ++ ) {
            for (int l = 1; l + i - 1 <= n; l ++ ) {
                int r = l + i - 1;
                System.out.println(l + "   " + r);
                f[l][r] = 1000000000;
                for (int k = l; k <= r; k ++ ) {
                    f[l][r] = Math.min(f[l][k] +  f[k + 1][r] + g[r] - g[l - 1], f[l][r]);
                }
            }
        }

        System.out.println(f[1][n]);
    }
}
