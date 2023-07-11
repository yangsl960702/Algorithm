package 第三章搜索与图论.最短路问题.Dijstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Dijstra暴力法
 *Dijstra过程：
 * 1.找到当前还未确定最短距离的点
 * 2.用找到的点更新其他点的距离
 * 3.将该点标记已找到最短距离
 *
 * 暴力体现在：寻找未确定距离的最短的点过程是暴力的，时间复杂度是O(N)。
 *暴力Dijstra一般用在稠密图
 */
public class Dijstra暴力 {
    public static final int N = 510;
    public static int[][] g = new int[N][N];
    public static int n, m;
    public static int[] dist = new int[N];
    public static boolean[] st = new boolean[N];

    private static void dijkstra() {
        dist[1] = 0;

        for (int i = 1; i <= n; i ++ ) {
            int t = -1;

            for (int j = 1; j <= n; j ++ ) {
                if (!st[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }

            for (int j = 1; j <= n; j ++ ) {
                if (!st[j]) {
                    dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
                }
            }

            st[t] = true;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        for (int i = 1; i <= n; i ++ ) {
            for (int j = 1; j <= n; j ++ ) {
                if (i == j) {
                    g[i][j] = 0;
                }else {
                    g[i][j] = 1000000000;
                }
            }
        }

        while (m -- > 0) {
            String[] split1 = reader.readLine().split(" ");
            int a = Integer.parseInt(split1[0]);
            int b = Integer.parseInt(split1[1]);
            int c = Integer.parseInt(split1[2]);
            g[a][b] = Math.min(g[a][b], c);
        }

        Arrays.fill(dist, 1000000000);

        dijkstra();

        if (dist[n] == 1000000000) {
            System.out.println(-1);
        }else {
            System.out.println(dist[n]);
        }
    }
}
