import java.util.Scanner;

public class Main5597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = new int[31];

        int target = 0;
        for(int i = 0 ; i < 28 ; i++){
            target = Integer.parseInt(sc.nextLine());
            array[target] = target;
        }

        for(int j = 1 ; j < 31 ; j++){
            if(array[j] == 0)
                System.out.println(j);
        }
    }
}

