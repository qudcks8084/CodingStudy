import java.util.Scanner;

public class Main10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = 0;
        int max = -1000001;
        int min = 1000001;

        for(int i = 0 ; i < a; i++){
            b = sc.nextInt();
            if( b > max)
                max = b;
            if( b < min)
                min = b;
        }
        System.out.println(Integer.toString(min) + " " + Integer.toString(max));
    }
}
