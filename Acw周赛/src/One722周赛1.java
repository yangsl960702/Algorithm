import java.util.Scanner;

public class One722周赛1 {
    public static int t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 400; i ++ ) builder.append("abc");
        while (t -- > 0) {
            int n = scanner.nextInt();
            System.out.println(builder.substring(0, n));
        }
    }
}
