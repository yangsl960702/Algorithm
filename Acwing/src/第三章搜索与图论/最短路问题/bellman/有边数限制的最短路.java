package 第三章搜索与图论.最短路问题.bellman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * bellman-ford：
 * 适用于：求有边数限制的(可以存在负权边)最短路径，也可用来判断是否存在环路
 * 但是由于时间复杂度的原因很少使用，一般spfa即可
 * 时间复杂度： O(N*M)
 * bellman-ford求最短路思路和前述dij发生颠覆性的变化，后续的spfa算法也延续了这一思路
 * dij 遍历点逐步更新最短距离
 * bellman 遍历边逐步更新最短距离
 * 算法步骤：
 * 1.限制可走边数
 * 2.对dist作备份，防止发生连锁更新
 * 3.遍历m条边更新最短距离 --- 更新条件要使用备份dist
 */
public class 有边数限制的最短路 {
    public static final int N = 510;
    public static Point[] g = new Point[10010];
    public static int[] dist = new int[N];
    public static int[] last = new int[N];

    public static int n, m, k, idx;

    public static void bellman_ford() {
        Arrays.fill(dist, 1000000000);
        dist[1] = 0;

        for (int i = 0; i < k; i ++ ) {
            //备份
            last = Arrays.copyOf(dist, n + 1);
            for (int j = 0; j < idx; j ++ ) {
                int a = g[j].a, b = g[j].b, w = g[j].w;
                if (last[b] > last[a] + w) {
                    dist[b] = last[a] + w;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        k = Integer.parseInt(split[2]);

        while (m -- > 0) {
            String[] split1 = reader.readLine().split(" ");
            int a = Integer.parseInt(split1[0]);
            int b = Integer.parseInt(split1[1]);
            int w = Integer.parseInt(split1[2]);
            Point point = new Point(a, b, w);
            g[idx ++ ] = point;
        }

        bellman_ford();

        if (dist[n] > 1000000000 / 2) System.out.println("impossible");
        else System.out.println(dist[n]);
    }
}

class Point{
    int a;
    int b;
    int w;
    public Point(int a,int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }
}



