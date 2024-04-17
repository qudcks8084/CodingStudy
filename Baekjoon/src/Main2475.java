import java.util.Scanner;

public class Main2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long result = 0;
        long temp = 0;
        for(int i = 0 ; i < 5 ; i++){
            temp = sc.nextLong();
            result += temp * temp;
        }
        System.out.println(result%10);
    }
}
