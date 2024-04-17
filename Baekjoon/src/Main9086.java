import java.util.Scanner;

public class Main9086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = Integer.parseInt(sc.nextLine());
        String[] target = {};
        for(int i = 0 ; i < max ; i++){
            target = sc.nextLine().split("");
            if(target.length > 1) {
                System.out.println(target[0] + target[target.length - 1]);
            } else
                System.out.println(target[0] + target[0]);
        }

    }
}
