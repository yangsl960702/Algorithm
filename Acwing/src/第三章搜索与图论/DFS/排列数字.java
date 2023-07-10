package 第三章搜索与图论.DFS;

import java.util.Scanner;

/**
 * 基础模板dfs，即不需要剪枝优化，直接一条路走到黑再重头开始
 * 过程是：
 * 1.找到终止条件
 * 2.向前走 -> 递归向前走 -> 还原现场
 */
public class 排列数字 {
    public static int[] path = new int[10];
    public static boolean[] st = new boolean[10];
    public static int n;
    public static void dfs(int x) {
        if(x == n) {
            for(int i = 0; i < n; i ++ ) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < n; i ++ ) {
            if (st[i] == false) {
                st[i] = true;
                path[x] = i + 1;

                dfs(x + 1);

                st[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dfs(0);
    }
}
