package 第三章搜索与图论.DFS;

import java.util.Arrays;
import java.util.Scanner;


/*
DFS模板基础班，该题主要是快捷方面的衡量2点
1.横、竖、对角线、反对角线不会产生冲突
2.每一行一定会有一个棋子
** 补充：
    这种做法横是逐步向下的，保障了每一行只选一个，所以不再需要判断行
 */
public class n皇后问题 {
    public static int n;
    public static final int N = 10;
    public static char[][] g = new char[N][N];
    public static boolean[] col = new boolean[N];
    public static boolean[] dig = new boolean[2 * N];
    public static boolean[] udig = new boolean[2 * N];

    public static void dfs(int x) {
          if (x == n) {
                  for(int i = 0; i < n; i ++ ) {
                      for(int j = 0; j < n; j ++ ) {
                          System.out.print(g[i][j]);
                      }
                      System.out.println();
                  }
                  System.out.println();
              }

              for(int j = 0; j < n; j ++ ) {
                  if (!(col[j] || dig[j - x + N] || udig[j + x])) {
                      col[j] = dig[j - x + N] = udig[j + x] = true;
                      g[x][j] = 'Q';

                      dfs(x + 1);

                      col[j] = dig[j - x + N] = udig[j + x] = false;
                      g[x][j] = '.';
                  }
          }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 0; i < n; i ++ )
            Arrays.fill(g[i], '.');

        dfs(0);
    }
}
