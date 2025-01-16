import java.util.Scanner;

public class Main11052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine()) ;

        String[] arr = sc.nextLine().split(" ");

        int[] dp = new int[N+1];

        for(int i = 1 ; i < N+1 ; i++){
            for(int j = 1 ; j < N+1 ; j++){
                if(j-i > 0){
                    dp[j] = Math.max(dp[j], (dp[j-1] + Integer.parseInt(arr[i])));
                }
            }
        }

        for(int n : dp)
            System.out.println(n);

    }
}
