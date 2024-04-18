import java.util.Scanner;

public class Main11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = Integer.parseInt(sc.nextLine());
        String[] b = sc.nextLine().split("");
        int result = 0;
        for(int i = 0 ; i < a ; i++){
            result += Integer.parseInt(b[i]);
        }
        System.out.println(result);
    }
}
