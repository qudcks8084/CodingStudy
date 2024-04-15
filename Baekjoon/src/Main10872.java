import java.util.Scanner;

public class Main10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        int fact = 1;
        for (int i = 1; i <= max; i++)
            fact *= i;
        System.out.println(fact);
    }
}
