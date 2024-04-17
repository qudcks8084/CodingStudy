import java.util.Scanner;

public class Main2754 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        if((int)target.charAt(0) - 69 == 1)
            System.out.println(0.0);
        else {
            int result = Math.abs((int) target.charAt(0) - 69);
            if ((int) target.charAt(1) == 43) {
                System.out.println((float)(result + 0.3));
            } else if ((int) target.charAt(1) == 45) {
                System.out.println((float)(result - 0.3));
            } else {
                System.out.println((float) result);
            }
        }
    }
}
