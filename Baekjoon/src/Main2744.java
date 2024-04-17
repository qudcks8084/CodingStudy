import java.util.Scanner;

public class Main2744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String list = sc.nextLine();
        for(int i = 0 ; i < list.length() ; i++){
            if((int)list.charAt(i) > 96)
                System.out.print((char)(list.charAt(i) - 32));
            else
                System.out.print((char)(list.charAt(i) + 32));
        }
    }
}
