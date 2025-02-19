import java.util.Scanner;

public class Main11729 {

    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        int N = sc.nextInt();

        sb.append((long) Math.pow(2, N) - 1).append("\n");
        hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }

    static void hanoi(int n, int from, int tmp, int to) {
        if (n == 0) return;
        hanoi(n - 1, from, to, tmp);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, tmp, from, to);
    }

}
