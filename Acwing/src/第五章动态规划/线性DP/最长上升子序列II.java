package 第五章动态规划.线性DP;

import java.util.Scanner;

/**
 * f[i]的含义是最长递增子序列的长度为i时记录的最小值，
 * 整个数组呈现严格单调递增的
 *
 * 具体思路是：
 * 遍历g时，通过二分查找找到它可以放入的位置，使得f数组内部的值不断更新，
 * 最后f数组的长度就是最长递增子序列的长度
 *
 * 1 我的是找到第一个大于等于它的数，进行替换，代码会有些冗余
 *
 * 2 更好的做法是找到最后一个小于它的数，那么下一个数必然大于等于它，直接替换即可
 */
public class 最长上升子序列II {
    public static int N = 100010;
    public static int[] f = new int[N];
    public static int n;
    public static int[] g = new int[N];
    public static int idx = 1;

    public static int find(int x) {
        int l = 1, r = idx;
        while(l < r) {
            int mid = l + r >> 1;
            if (f[mid] < x) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 1; i <= n; i ++ ) {
            g[i] = scanner.nextInt();
        }

        f[1] = g[1];
        for (int i = 2; i <= n; i ++ ) {
            int j = find(g[i]);
            if (j < idx) f[j] = g[i];
            else {
                if (f[j] >= g[i]) f[j] = g[i];
                else f[ ++ idx] = g[i];
            }
        }
        System.out.println(idx);
    }
}
