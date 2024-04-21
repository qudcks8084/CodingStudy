import java.util.Scanner;

public class Main1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfNumeric = Integer.parseInt(sc.nextLine());
        String[] targetNumberString = sc.nextLine().split(" ");
        int count = 0;
        int a = 0;
        for(int i = 0 ; i < numOfNumeric ; i++){
            a = Integer.parseInt(targetNumberString[i]);
            if(a > 2){
                for(int j = 2 ; j < a ; j++){
                    if( a % j == 0 ){
                        targetNumberString[i] = "0";
                        break;
                    }
                }
            }else if(a < 2){
                targetNumberString[i] = "0";
            }

        }
        for(int i = 0 ; i < targetNumberString.length ; i++){
            if(Integer.parseInt(targetNumberString[i]) != 0)
                count += 1;
        }
        System.out.println(count);
    }
}
