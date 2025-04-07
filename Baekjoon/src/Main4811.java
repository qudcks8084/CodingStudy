import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main4811 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        * 1초에는 1개짜리를 고를수 밖에 없다.
        * 그 다음부터는 1개를 고를 확률 + 반개를 고를 경우의 수를 모두 더해나간다.
        * */

        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            int D = 2 * N;

            // dp[1개짜리 알약의 개수][시간]
            long[][] dp = new long[N][D + 1];

            // 처음에는 1개짜리를 고를수 밖에  없다.
            dp[0][1] = N;

            for(int i = 1 ; i < D ; i++){
                // 1개 짜리를 꺼낼 수 있는 경우
            }
        }
    }
}
