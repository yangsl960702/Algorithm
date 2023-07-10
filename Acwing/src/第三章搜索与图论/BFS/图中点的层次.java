package 第三章搜索与图论.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 典型BFS，BFS产生不了变化，一层一层的向外扩展的就是BFS，无脑队列存取
 * 图的构建：
 *      稀疏图：n 和 m不成平方比例即稀疏 --- 数组构成邻接表
 *      稠密图：n 和 m成平方比例即稠密 --- 邻接矩阵
 */
public class 图中点的层次 {
    public static int N = 100010;
    public static int[] head = new int[N];
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int idx = 0;
    public static int n, m;
    public static int[] dist = new int[N];

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = head[a];
        head[a] = idx ++ ;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        Arrays.fill(head, -1);
        while (m -- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            add(a, b);
        }
        Arrays.fill(dist, 1000000000);
        bfs();
        if (dist[n] == 1000000000) System.out.println(-1);
        else System.out.println(dist[n]);

    }

    private static void bfs() {
        dist[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (queue.size() > 0) {
            Integer peek = queue.peek();
            queue.remove();

            for (int i = head[peek]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] == 1000000000) {
                    dist[j] = dist[peek] + 1;
                    queue.add(j);
                }
            }
        }

    }
}
