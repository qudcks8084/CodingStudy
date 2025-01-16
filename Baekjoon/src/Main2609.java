import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int max = Math.max(a, b);
        int min = Math.min(a, b);

        // 최대공약수
        for(int i = min ; i > 0 ; i--){
            if(a % i == 0 && b % i == 0){
                System.out.println(i);
                break;
            }
        }

        // 최대공약수
        while(true){
            if (max % a == 0 && max % b == 0) {
                System.out.println(max);
                break;
            }else {
                max++;
            }
        }
    }
}
