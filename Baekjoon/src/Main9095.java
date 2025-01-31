import java.util.Arrays;
import java.util.Scanner;

public class Main9095 {
    static int[] arr;
    static int N, answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int testcase = 0; testcase < T; testcase++) {
            N = sc.nextInt();
            arr = new int[N];
            answer = 0;
            DFS(0, 0);
            System.out.println(answer);
        }
    }

    public static void DFS(int L, int sum) {
        if (sum == N) {
            answer++;
            return;
        }
        if (sum > N || L == N) return;

        arr[L] = 1;
        DFS(L + 1, sum + 1);
        arr[L] = 2;
        DFS(L + 1, sum + 2);
        arr[L] = 3;
        DFS(L + 1, sum + 3);

    }
}
