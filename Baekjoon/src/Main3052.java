import java.util.Scanner;

public class Main3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = new int[42];
        int numOfNewResult = 0;
        int target = 0;
        for(int i = 0 ; i < 10 ; i++){
            target = sc.nextInt() % 42;
            if(array[target] == 0){
                numOfNewResult++;
                array[target]++;
            }else
                array[target]++;
        }
        System.out.println(numOfNewResult);
    }
}
