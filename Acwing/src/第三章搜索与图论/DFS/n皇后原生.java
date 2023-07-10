package 第三章搜索与图论.DFS;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 原生n皇后做法
 * 直接无脑遍历x 和 y，用k做标记位放了几个棋子
 * y 到极值，y = 0， x ++
 * x 到极值，检查k是否符合要求，符合要求即输出
 */
public class n皇后原生 {
    public static int n;
    public static final int N = 10;
    public static boolean[] row = new boolean[N], col = new boolean[N];
    public static boolean[] dig = new boolean[2 * N];
    public static boolean[] udig = new boolean[2 * N];
    public static char[][] g = new char[N][N];

    public static void dfs(int x, int y, int k) {
        if (y == n) {
            x ++ ;
            y = 0;
        }
        if (x == n) {
            if (k == n) {
                for (int i = 0; i < n; i ++ ) {
                    for (int j = 0; j < n; j ++ ) {
                        System.out.print(g[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();
            }
            return;
        }

        dfs(x, y +1, k);
        if (!(row[x] || col[y] || dig[y - x + N] || udig[y + x])) {
            row[x] = col[y] = dig[y - x + N] = udig[y + x] = true;
            g[x][y] = 'Q';

            dfs(x, y + 1, k + 1);

            row[x] = col[y] = dig[y - x + N] = udig[y + x] = false;
            g[x][y] = '.';
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i ++ ) {
            Arrays.fill(g[i], '.');
        }
        dfs(0, 0, 0);
    }
}
