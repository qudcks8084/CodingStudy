import java.util.Scanner;

public class Main10995 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String format = "* ".repeat(n);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i ++){
            if(i %2 == 1) sb.append(" ");
            sb.append(format).append("\n");
        }
        System.out.println(sb);

    }
}
