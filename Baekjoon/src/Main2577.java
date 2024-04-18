import java.util.Scanner;

public class Main2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        String[] a ;
        int target = 1;
        for(int i = 0 ; i < 3 ; i++)
            target = target * sc.nextInt();
        a = Integer.toString(target).split("");
        for(int i = 0 ; i < a.length ; i++){
            array[Integer.parseInt(a[i])]++;
        }
        for(int i = 0 ; i < 10 ; i++){
            System.out.println(array[i]);
        }
    }
}
