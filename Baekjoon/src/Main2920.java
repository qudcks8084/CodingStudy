import java.util.Scanner;

public class Main2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().split(" ");
        boolean mixed = true;
        int gap = 0;
        for(int i = 0 ; i < 7 ; i++){
            gap = Math.abs(Integer.parseInt(array[i]) - Integer.parseInt(array[i+1]));
            if(gap != 1){
                System.out.println("mixed");
                mixed = false;
                break;
            }
        }
        if(mixed){
            gap = Integer.parseInt(array[0]) - Integer.parseInt(array[1]);
            if(gap == -1)
                System.out.println("ascending");
            else
                System.out.println("descending");
        }
    }
}
