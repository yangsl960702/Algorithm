import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 输入问题
 * nextInt()... 怎么取值杂七杂八
 */
public class One722周赛2 {
    public static List<String> all = new ArrayList<>();
    public static void dfs(int x, String[] auto, boolean[] st, StringBuilder s) {
        if (x == auto.length) {
            all.add(s.toString());
        }
        for (int i = 0; i < 3; i++) {
            if (!st[i]) {
                s.append(auto[i]);
                st[i] = true;

                dfs(x + 1, auto, st, s);

                s.delete(s.length() - auto[i].length(), s.length());
                st[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine().replaceAll("-", "").replaceAll(";", "")
                .replaceAll("_", "").toLowerCase();
        String b = scanner.nextLine().replaceAll("-", "").replaceAll(";", "")
                .replaceAll("_", "").toLowerCase();
        String c = scanner.nextLine().replaceAll("-", "").replaceAll(";", "")
                .replaceAll("_", "").toLowerCase();

        String[] auto = new String[]{a, b, c};
        boolean[] st = new boolean[3];
        dfs(0, auto, st, new StringBuilder());

        int n = Integer.parseInt(scanner.nextLine());
        while (n -- > 0) {
            boolean flag = false;
            String target = scanner.nextLine().replaceAll("-", "").replaceAll(";", "")
                    .replaceAll("_", "").toLowerCase();
            for (int i = 0; i < all.size(); i++) {
                if (all.get(i).equals(target)) {
                    flag = true;
                    break;
                }
            }
            if (flag) System.out.println("ACC");
            else System.out.println("WA");
        }
    }
}
