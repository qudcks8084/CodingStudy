import java.util.Scanner;

public class Main10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfArray = sc.nextInt();
        int target = sc.nextInt();
        int compare = 0;
        for(int i = 0 ; i < numOfArray ; i++){
            compare = sc.nextInt();
            if(compare < target) System.out.println(compare);
        }
    }
}
