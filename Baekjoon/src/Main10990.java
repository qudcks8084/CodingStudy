import java.util.Scanner;

public class Main10990 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < n-i ; j++){
                sb.append(" ");
            }
            sb.append("*");
            if(i > 1){
                for(int j = 0 ; j < 2*(i-1)-1; j++){
                    sb.append(" ");
                }
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
