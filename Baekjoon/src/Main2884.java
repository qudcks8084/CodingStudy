import java.util.Scanner;

public class Main2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int time = 0;
        if(a != 0)
            time = a * 60 + b - 45;
        else
            time = 24 * 60 + b - 45;
        if(time >= 1440)
            time -= 1440;
        System.out.println(time/60 + " " + time % 60);
    }
}
