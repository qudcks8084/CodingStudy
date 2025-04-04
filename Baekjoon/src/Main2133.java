import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2133 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] tile = new int[N + 1];

        if(N % 2 == 1){
            System.out.println(0);
            return;
        }

        tile[0] = 1;
        if(N >= 2) tile[2] = 3;

        int sum = 1;
        for(int i = 4; i <= N; i += 2){
            tile[i] = 3 * tile[i - 2] + 2 * sum;
            sum += tile[i - 2]; // 이전 타일들을 누적
        }

        System.out.println(tile[N]);

    }
}
