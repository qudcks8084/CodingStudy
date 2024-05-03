import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int R = 0;

        while( N >= 5 ){
            R += N / 5;
            N /=5;
        }
        System.out.println(R);
    }
}
