package 第三章搜索与图论.最短路问题.spfa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * spfa判断负环的原理：抽屉原理 --- n个点没有环路，那么最多有n - 1条边，那么对于每个点来说，
 * 只要在更新距离的时候有一个点走过的边数 >= n，则说明必存在环路，
 * 所以需要一个额外数组来记录走到某一点时已经走过的边数
 *
 * 注意点：
 * 存在负环不一定是从起点1开始，所以起始时需要将所有点都让入队列
 * 不需要给dist赋初始极大值，因为存在负权回路一定会从负权边引起连锁更新： 0 > 负值
 * 如果不存在负权回路，那么dist所有值一直是0
 *
 * 步骤：
 * 在产生距离更新的时候，即意味着从x -> y可以让距离变短，从x到y又加了一条边，即cnt[y] = cnt[x] + 1；
 * 当cnt[i] >= n时候，说明从x点 -> i点 已经成环
 */
public class Spfa判断负环 {
    public static int n, m, idx;
    public static final int N = 10010;
    public static int[] head = new int[N];
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int[] ws = new int[N];
    public static boolean[] st = new boolean[N];
    public static int[] dist = new int[N];
    public static int[] cnt = new int[N];

    public static void add(int a, int b, int w) {
        e[idx] = b;
        ne[idx] = head[a];
        ws[idx] = w;
        head[a] = idx ++ ;
    }

    public static int spfa() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i ++ ) {
            queue.add(i);
            st[i] = true;
        }

        while (queue.size() > 0) {
            Integer t = queue.peek();
            queue.remove();
            st[t] = false;

            for (int i = head[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if(dist[j] > dist[t] + ws[i]) {
                    dist[j] = dist[t] + ws[i];
                    cnt[j] = cnt[t] + 1;
                    if (cnt[j] >= n) return -1;
                    if (!st[j]) {
                        queue.add(j);
                        st[j] = true;
                    }
                }
            }
        }
        return 0;
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

        int spfa = spfa();
        if (spfa == 0) System.out.println("No");
        else System.out.println("Yes");
    }
}
