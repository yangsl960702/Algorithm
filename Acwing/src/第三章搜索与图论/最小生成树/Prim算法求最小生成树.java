package 第三章搜索与图论.最小生成树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Prime算法用于求最小生成树
 * 适用于稠密图，时间复杂度是O(N^2)
 * 整体流程基本和dijstra算法相似，主要是dist的含义产生了变化：
 * 当前还没有确定最短到起点距离的点的最小值 --- dijstra
 * 当前还没有确定最短到集合的点的最小值 --- prime
 * 1.遍历n个点，试图将每个点都纳入，即s[t]皆为true
 * 2.找到当前还没确定到 集合 的点的最小距离  --- dij是到起点 (dist[t] > dist[j])
 * 3.判断该点能不能到集合，不能到直接返回无法构成最小生成树，即：
 * dist[t] == MAX，否则就可以加入，标记该点已经加入集合，即 st[t] = true；
 * 4.用当前最新纳入集合的点，去更新其他点到当前集合的距离，即
 * dist[j] = Math.min(dist[j], g[t][j]
 *
 */
public class Prim算法求最小生成树 {
    public static final int N = 510;
    public static int[][] g = new int[N][N];
    public static int n, m;
    public static boolean[] st = new boolean[N];
    public static int[] dist = new int[N];

    public static int prime() {
        int res = 0;
        Arrays.fill(dist, 1000000000);
        dist[1] = 0;

        for (int i = 1; i <= n; i ++ ) {
            int t = -1;
            for (int j = 1; j <= n; j ++ ) {
                if (st[j] == false && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            if (dist[t] == 1000000000) return 1000000000;
            res += dist[t];
            st[t] = true;

            for (int j = 1; j <= n; j ++ ) dist[j] = Math.min(dist[j], g[t][j]);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        for (int i = 1; i <= n; i ++ ) {
            for (int j = 1; j <= n; j ++ ) {
                if (i == j) g[i][j] = 0;
                else g[i][j] = 1000000000;
            }
        }

        for (int i = 0; i < m; i ++ ) {
            int a, b, c;
            String[] abc = reader.readLine().split(" ");
            a = Integer.parseInt(abc[0]);
            b = Integer.parseInt(abc[1]);
            c = Integer.parseInt(abc[2]);
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }

        int j = prime();
        if (j == 1000000000) System.out.println("impossible");
        else System.out.println(j);
    }
}
