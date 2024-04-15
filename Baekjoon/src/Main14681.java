import java.util.Scanner;
public class Main14681 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean x = Integer.parseInt(sc.nextLine()) > 0;
        boolean y = Integer.parseInt(sc.nextLine()) > 0;

        if(x){
            if(y) System.out.println("1");
            else System.out.println("4");
        }
        else{
            if(y) System.out.println("2");
            else System.out.println("3");
        }
    }
}
