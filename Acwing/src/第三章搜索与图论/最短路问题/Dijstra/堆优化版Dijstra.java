package 第三章搜索与图论.最短路问题.Dijstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 堆优化版本的Dijstra优化体现在：将查找未确定最短距离的距离最短点时间复杂度由 N 降低为 LogN
 * 堆优化Dijstra适用场景：稀疏图
 * 堆优化版Dijstra时间复杂度为O(NLogN) ---> 实际为O(NLogM)，稀疏图N和M是一个级别的，所以无所谓
 */
public class 堆优化版Dijstra {
    public static final int N = 200000;
    public static int[] head = new int[N];
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int[] w = new int[N];
    public static int n, m, idx;
    public static int[] dist = new int[N];
    public static boolean[] st = new boolean[N];
    public static Queue<Point> queue = new PriorityQueue<>(new Comparator<Point>() {

        @Override
        public int compare(Point o1, Point o2) {
            if (o1.dist > o2.dist) return 1;
            else if (o1.dist < o2.dist) return -1;
            else return 0;
        }
    });

    public static void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = head[a];
        w[idx] = c;
        head[a] = idx ++ ;
    }

    public static void dijkstra() {
        queue.add(new Point(1, 0));
        while (queue.size() > 0) {
            Point peek = queue.peek();
            queue.remove();
            if (st[peek.point]) continue;
            st[peek.point] = true;

            for (int i = head[peek.point]; i != -1; i = ne[i]) {
                int j = e[i], wi = w[i];
                dist[j] = Math.min(dist[j], dist[peek.point] + wi);
                queue.add(new Point(j, dist[j]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        Arrays.fill(head, -1);
        Arrays.fill(dist, 1000000000);
        dist[1] = 0;

        while (m -- > 0) {
            String[] split1 = reader.readLine().split(" ");
            int a = Integer.parseInt(split1[0]);
            int b = Integer.parseInt(split1[1]);
            int c = Integer.parseInt(split1[2]);
            add(a, b, c);
        }

        for (int i = 0; i < idx; i ++ ) {
            System.out.println(e[i] + " " + w[i]);
        }

        dijkstra();

        if (dist[n] != 1000000000) System.out.println(dist[n]);
        else System.out.println(-1);
    }
}

class Point{
    int point;
    int dist;
    public Point(int x, int y) {
        point = x;
        dist = y;
    }
}
