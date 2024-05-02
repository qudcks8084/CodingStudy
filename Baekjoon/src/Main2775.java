import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(bf.readLine());
            int N = Integer.parseInt(bf.readLine());
            int[][] array = new int[K + 1][N];

            for (int j = 0; j < N; j++)
                array[0][j] = j + 1;

            for (int j = 1; j <= K; j++) {
                for (int k = 0; k < N; k++) {
                    for (int r = 0; r <= k; r++) {
                        array[j][k] += array[j - 1][r];
                    }
                }
            }
            System.out.println(array[K][N-1]);
        }
    }
}
