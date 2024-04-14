import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1152 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        StringTokenizer stringTokenizer = new StringTokenizer(inputLine," ");
        System.out.println(stringTokenizer.countTokens());

        scanner.close();

    }
}