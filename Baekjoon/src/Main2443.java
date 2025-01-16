import java.util.Scanner;

public class Main2443 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = 0 ; j < n-i-1; j++){
                sb.append(" ");
            }
            for(int j = 0 ; j < i * 2 + 1 ; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
