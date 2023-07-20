package 第三章搜索与图论.最小生成树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * kruskal求最小生成树
 * 适用于稀疏图，算法总体思想是：
 * 1.将所有边按照权值从小到大排序
 * 2.每次纳入权值最小的边，判断边中的点是否已经纳入集合，没有纳入则纳入集合并且更新权值
 * 3.所有边都走过一遍后，确保所有的点都已经纳入，则最小生成树生成成功
 * 实现过程：
 * 1.构造边类，用集合将边进行存储，并且按照权值排序
 * 2.遍历边，每次判断所拿取的边的点是否已经纳入集合 --- 涉及到并查集
 * 如果纳入则跳过，如果没纳入则纳入集合，更新权值 + 已纳入点的个数
 * 3.判断是否所有点都纳入成功
 */
public class Kruskal求最小生成树 {
    public static final int M = 500010;
    public static final int N = 100010;
    public static int n, m;
    public static List<Point> g = new ArrayList<>();
    public static int[] p = new int[N];
    public static int[] cnt = new int[N];

    public static int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    public static int kruskal() {
        int res = 0;
        for (int i = 0; i < g.size(); i ++ ) {
            Point point = g.get(i);
            int x = point.x, y = point.y, w = point.w;
            if (find(x) != find(y)) {
                res += w;
                cnt[find(y)] += cnt[find(x)];
                p[find(x)] = find(y);//x 合并到 y 中
            }
        }
        for (int i = 1; i <= n; i ++ ) {
            if (cnt[i] == n) return res;
        }
        return 1000000000;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        for (int i = 1; i <= n; i ++ ) {
            p[i] = i;
            cnt[i] = 1;
        }

        for (int i = 0; i < m; i ++ ) {
            String[] abw = reader.readLine().split(" ");
            int a, b, w;
            a = Integer.parseInt(abw[0]);
            b = Integer.parseInt(abw[1]);
            w = Integer.parseInt(abw[2]);
            g.add(new Point(a, b, w));
        }

        Collections.sort(g);

        int i = kruskal();

        if (i != 1000000000) System.out.println(i);
        else System.out.println("impossible");




    }
}

class Point implements Comparable<Point> {
    int x;
    int y;
    int w;
    public Point(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }

    @Override
    public int compareTo(Point o) {
        if (this.w > o.w) return 1;
        else if (this.w < o.w) return -1;
        else return 0;
    }
}
