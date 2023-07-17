package 第三章搜索与图论.二分图;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1.什么是二分图
 * 图中的点可以分为x、y两个集合，集合之间的点两两相连，集合内部的点不产生边
 * 2.二分图判定核心
 * 最少两个顶点，存在环时，环的边数必然是偶数
 * 3.解决办法
 * DFS 逐步染色，成功则代表从该点出发到最深处都染色成功，否则就代表着染色失败，不是二分图
 * 判断条件 -- 是否染色 ：
 *  没有 --- dfs尝试进行染色，但凡逐渐向内染色失败，则代表着不是二分图，返回false
 *  染色 --- 判断是否和当前之间相连的点颜色相同，相同则代表不是二分图，返回false
 *注意：
 * 另外图不一定是连通的，所以必须每个点都要进行尝试
 */
public class 染色法判定二分图 {
    public static final int N = 200010;
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int[] head = new int[N];
    public static int n, m, idx;
    public static int[] color = new int[N];

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = head[a];
        head[a] = idx ++ ;
    }

    public static boolean dfs(int x, int u) {
        color[x] = u;
        for (int i = head[x]; i != -1; i = ne[i]) {
            int j = e[i];
            if (color[j] == 0) {
                if (!dfs(j, 3 - u)) return  false;
            }else if (color[j] == color[x]) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        Arrays.fill(head, -1);
        for (int i = 0; i < m; i ++ ) {
            String[] ab = reader.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            add(a, b);
            add(b, a);
        }

        boolean flag = true;
        for (int i = 1; i <= n; i ++ ) {
            if (color[i] == 0) {
                if (!dfs(i, 1)) {
                    flag = false;
                    break;
                }
            }
        }
        if (!flag) System.out.println("No");
        else System.out.println("Yes");
    }
}
