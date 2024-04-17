import java.io.IOException;
import java.util.Scanner;

public class Main15964 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        if( a >= 0 && b <= 100000)
            System.out.println(a*a - b*b);
    }
}
