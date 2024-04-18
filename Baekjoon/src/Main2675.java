import java.util.Scanner;

public class Main2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        for(int i = 0 ; i < a ; i++){
            String[] b = sc.nextLine().split(" ");
            String[] c = b[1].split("");
            for (int j = 0; j < c.length ; j++) {
                for(int k = 0 ; k < Integer.parseInt(b[0]) ; k++) {
                    System.out.print(c[j]);
                }
            }
            System.out.println();
        }
    }
}
