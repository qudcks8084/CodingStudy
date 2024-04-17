import java.util.Scanner;

public class Main2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        String blank = " ";
        String star = "*";
        for(int i = 1 ; i <= max ; i++){
            for(int j = 0 ; j < max - i ; j++)
                System.out.print(" ");
            for(int k = 0 ; k < i ; k++)
                System.out.print("*");
            System.out.println();
        }
    }
}
