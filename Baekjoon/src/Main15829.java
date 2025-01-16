import java.io.IOException;
import java.util.Scanner;

public class Main15829 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int L = scan.nextInt();
        String sentence = scan.next();
        long hashnumber = 0;
        long power = 1;
        int M = 1234567891;

        for (int i=0; i<L; i++) {
            int alpha = sentence.charAt(i) - 96;
            hashnumber = (hashnumber + alpha * power) % M;
            power = (power * 31) % M;
        }
        System.out.println(hashnumber);
    }
}
