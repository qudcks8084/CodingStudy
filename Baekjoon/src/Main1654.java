import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int max = Integer.MIN_VALUE;

        int[] arr = new int[k];
        for (int i = 0 ; i < k ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }


        for( ; max > 0 ; max--){
            int tmp = 0;
            for(int i = 0 ; i < k ; i++){
                tmp += arr[i] / max;
            }
            if(tmp == n){
                System.out.println(max);
                break;
            }
        }
    }
}
