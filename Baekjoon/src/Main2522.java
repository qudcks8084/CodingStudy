import java.util.Scanner;

public class Main2522 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i = 1 ; i < 2*n ; i++){
            int blank = Math.abs(n-i);

            for(int j = 0 ; j < blank ; j++){
                sb.append(" ");
            }
            for(int j = 0 ; j < n-blank ; j++){
                sb.append("*");
            }   

            sb.append("\n");
        }

        System.out.println(sb);

    }
}
