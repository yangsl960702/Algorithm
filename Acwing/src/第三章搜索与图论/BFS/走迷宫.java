package 第三章搜索与图论.BFS;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BFS基于模板
 * BFS适用场景：1. 权重相等求最短路径 2.树涉及层次遍历相关题目(层次遍历、宽度、高度)
 */
public class 走迷宫 {



    public static final int N = 110;
    public static int[][] g = new int[N][N];
    public static int[][] dist = new int[N][N];
    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int n, m;

    public static void bfs() {
        for(int i = 0; i < N; i ++ ) {
            Arrays.fill(dist[i], 1000000000);
        }
        dist[1][1] = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1));

        while (queue.size() > 0) {
            Point point = queue.peek();
            queue.remove();
            int x = point.x, y = point.y;
            for(int i = 0; i < 4; i ++ ) {
                int a = x + dx[i], b = y + dy[i];
                if (0 < a && a <= n && 0 < b && b <= m
                && dist[a][b] == 1000000000 && g[a][b] == 0) {
                    dist[a][b] = dist[x][y] + 1;
                    queue.add(new Point(a, b));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 1; i <= n; i ++ ) {
            for (int j = 1; j <= m; j ++ ) {
                g[i][j] = scanner.nextInt();
            }
        }

        bfs();
        System.out.println(dist[n][m]);
    }
}

class Point{
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
