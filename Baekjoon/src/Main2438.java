import java.util.Scanner;

public class Main2438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = sc.nextInt();
        for(int i = 1 ; i <= max ; i++){
            for(int j = 0 ; j < i ; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
