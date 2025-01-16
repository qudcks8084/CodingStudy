import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        String[] tShirt = bf.readLine().split(" ");
        String[] input = bf.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);

        int num_of_shirt = 0;
        for (String s : tShirt) {
            int tmp = Integer.parseInt(s);
            num_of_shirt += tmp / t;
            if(tmp % t != 0) num_of_shirt++;
        }

        sb.append(num_of_shirt).append("\n");
        sb.append(n / p).append(" ").append(n % p);

        System.out.println(sb);
    }
}
