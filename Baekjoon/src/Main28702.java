
import java.util.Scanner;

public class Main28702 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String tmp = sc.next();
        if(tmp.equals("Fizz")){
            String second = sc.next();
            if(second.equals("Buzz")) System.out.println("Fizz");
            else {
                if((Integer.parseInt(second) + 2) % 5 == 0) System.out.println("FizzBuzz");
                else System.out.println("Fizz");
            }
        }else if(tmp.equals("Buzz")){
            String second = sc.next();
            if(second.equals("Fizz")){
                System.out.println(sc.nextInt() + 2);
            }else{
                System.out.println(Integer.parseInt(second) + 2);
            }
        }else{
            int num = Integer.parseInt(tmp) % 15;
            if(num == 7 || num == 2) System.out.println("Buzz");
            else{
                System.out.println(Integer.parseInt(tmp) + 3);
            }
        }
    }
}
