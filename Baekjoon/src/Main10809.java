import java.util.Scanner;

public class Main10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        int[] array = new int[26];
        int index = 0;
        for(int i = 0 ; i < target.length() ; i++){
            index = target.charAt(i) - 97;
            if(array[index] == 0)
                array[index] = i+1;
        }
        for(int i = 0 ; i < 26 ; i++){
            System.out.print( (array[i]-1) + " ");
        }
    }
}
