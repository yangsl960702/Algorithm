package 第三章搜索与图论.最短路问题.多源最短路;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * floyd适用于：求多源最短路路径
 * 时间复杂度：O(N^3)
 * 步骤：
 * 1.拿一个中转点K逐步去更新邻接矩阵的点与点之间的距离，直到每一个点都当作为过中转点，即
 * 意味着距离更新完成
 * 注意：
 * 为了确保中转站在每一条路径上尝试过，所以循环的最外层必须是k
 */
public class Floyd {
    public static final int N = 210;
    public static int n, m, k;
    public static int[][] dist = new int[N][N];

    public static void floyd() {

        for (int k = 1; k <= n; k ++ ) {
            for (int i = 1; i <= n; i ++ ) {
                for (int j = 1; j <= n; j ++ ) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
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

        for (int i = 1; i <= n; i ++ ) {
            for (int j = 1; j <= n; j ++ ) {
                if (i == j) {
                    dist[i][j] = 0;
                }else {
                    dist[i][j] = 1000000000;
                }
            }
        }

        for (int i = 0; i < m; i ++ ) {
            String[] split1 = reader.readLine().split(" ");
            int a = Integer.parseInt(split1[0]);
            int b = Integer.parseInt(split1[1]);
            int c = Integer.parseInt(split1[2]);
            dist[a][b] = Math.min(dist[a][b], c);
        }

        floyd();

        while (k -- > 0) {
            String[] s = reader.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            if (dist[a][b] > 1000000000 / 2) System.out.println("impossible");
            else System.out.println(dist[a][b]);
        }
    }
}
