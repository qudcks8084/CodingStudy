import java.util.Scanner;

public class Main8958{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        String target ;
        int bonus = 0;
        int totalScore = 0;
        for(int i = 0 ; i < a ; i++){
            target = sc.nextLine();
            totalScore = 0;
            bonus = 0;
            for(int j = 0 ; j < target.length() ; j++){
                if(target.charAt(j) == 'O'){
                    totalScore = totalScore + 1 + bonus;
                    bonus++;
                }else{
                    bonus = 0;
                }
            }
            System.out.println(totalScore);
        }

    }
}
