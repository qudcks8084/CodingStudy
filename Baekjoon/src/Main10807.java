import java.util.Scanner;

public class Main10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfArray = Integer.parseInt(sc.nextLine());
        String[] array = sc.nextLine().split(" ");
        String target = sc.nextLine();
        int result = 0;
        for(int i = 0 ; i < numOfArray ; i++){
            if(target.equals(array[i])) result++;
        }
        System.out.println(result);
    }
}
