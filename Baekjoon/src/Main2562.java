import java.util.Scanner;

public class Main2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = 0;
        int max = 0;
        int maxIndex = 0;
        for(int i = 1 ; i <= 9 ; i++){
            target = sc.nextInt();
            if(target > max){
                max = target;
                maxIndex = i;
            }
        }
        System.out.println(max + "\n" + maxIndex);

    }
}
