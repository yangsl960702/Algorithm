package 第三章搜索与图论.拓扑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 拓扑序列： 可以用来求图是否有回路(但是一般不用，常用spfa)
 * 新开一个数组记录入度，入度为0则将其入队，直到所有点都清空
 * 如果路径记录数组不等于n，则认为存在回路
 */
public class 有向图的拓扑序列 {
    public static final int N = 100010;
    public static int n, m, idx;
    public static int[] head = new int[N];
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int[] cnt = new int[N];
    public static Queue<Integer> queue = new LinkedList<>();
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = head[a];
        cnt[b] ++ ;
        head[a] = idx ++ ;
    }

    public static void topo() {

        while (queue.size() > 0) {
            Integer peek = queue.peek();
            queue.remove();
            list.add(peek);
            for (int i = head[peek]; i != -1; i = ne[i]) {
                int j = e[i];
                cnt[j]--;
                if (cnt[j] == 0) queue.add(j);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        Arrays.fill(head, -1);

        while (m -- > 0) {
            String[] split1 = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(split1[0]);
            int b = Integer.parseInt(split1[1]);
            add(a, b);
        }

        for (int i = 1; i <= n; i ++ ) {
            if (cnt[i] == 0) {
                queue.add(i);
            }
        }

        topo();

        if (list.size() != n) {
            System.out.println(-1);
        }else {
            for (int i = 0; i < list.size(); i ++ ) {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}
