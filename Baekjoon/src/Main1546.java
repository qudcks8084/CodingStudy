import java.util.Scanner;

public class Main1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        String[] b= sc.nextLine().split(" ");
        int max = 0;
        int target = 0;
        double sumOfArray = 0;
        for(int i = 0 ; i < a ; i++){
            target = Integer.parseInt(b[i]);
            if(target > max){
                max = target;
            }
        }
        for(int i = 0 ; i < a ; i++){
            target = Integer.parseInt(b[i]);
            sumOfArray+= (double) (target * 100) /max;;
        }
        System.out.println(sumOfArray/a);
    }
}
