package 第三章搜索与图论.二分图;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 二分图的最大匹配 {
    public static final int N = 100010;
    public static final int M = 510;
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int[] head = new int[M];
    public static int n1, n2, m, idx;
    public static boolean[] st = new boolean[M];
    public static int[] match = new int[M];

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = head[a];
        head[a] = idx ++ ;
    }

    public static boolean find(int x) {
        for (int i = head[x]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                if (match[j] == 0 || find(match[j])) {
                    match[j] = x;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        n1 = Integer.parseInt(nm[0]);
        n2 = Integer.parseInt(nm[1]);
        m = Integer.parseInt(nm[2]);

        Arrays.fill(head, -1);
        for (int i = 0; i < m; i ++ ) {
            String[] ab = reader.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            add(a, b);
        }

        int res = 0;
        for (int i = 1; i <= n1; i ++ ) {
            Arrays.fill(st, false);
            if (find(i)) res ++ ;
        }
    }
}
