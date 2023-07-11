package 第三章搜索与图论.最短路问题.spfa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * spfa适用于：1.求存在负权边的单源最短路径 2.求是否存在环(一般情况都可过，过不了换拓扑或者是bellman)
 * 时间复杂度：O(N*M)?
 * 主题思想：只有产生过更新的点，其与它相连的边的最短距离才可能产生更新
 * st用来记录当前点是否已经在队列中待更新
 * 步骤：
 * 1.队列头取点，将st置为false，即该点移除队列处于不需要更新的状态
 * 2.判断距离是否需要更新，如果更新则更新距离，并且判断j点是否已经在待更新序列，不再则放入并做标记
 * 3.队列为空即没有点的距离再产生更新，终止
 */
public class Spfa求最短路 {
    public static final int N = 100010;
    public static int n, m, idx;
    public static boolean[] st = new boolean[N];
    public static int[] dist = new int[N];
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int[] head = new int[N];
    public static int[] ws = new int[N];

    public static void add(int a, int b, int w) {
        e[idx] = b;
        ne[idx] = head[a];
        ws[idx] = w;
        head[a] = idx ++ ;
    }

    public static void spfa() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        st[1] = true;

        while (queue.size() > 0) {
            Integer t = queue.peek();
            queue.remove();
            st[t] = false;
            for (int i = head[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + ws[i]) {
                    dist[j] = dist[t] + ws[i];
                    if (!st[j]) {
                        queue.add(j);
                        st[j] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        Arrays.fill(head, -1);

        for (int i = 0; i < m; i ++ ) {
            String[] split1 = reader.readLine().split(" ");
            int a = Integer.parseInt(split1[0]);
            int b = Integer.parseInt(split1[1]);
            int w = Integer.parseInt(split1[2]);
            add(a, b, w);
        }

        spfa();

        if (dist[n] > Integer.MAX_VALUE / 2) System.out.println(-1);
        else System.out.println(dist[n]);
    }
}

