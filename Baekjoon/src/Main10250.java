import java.util.Scanner;

public class Main10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        int room = 0;
        int floor = 0;
        for(int i = 0 ; i < a ; i++){
            String[] b = sc.nextLine().split(" ");
            if(Integer.parseInt(b[0]) == 1){
                floor = 1;
                room = Integer.parseInt(b[2]);
            }else{
                if(Integer.parseInt(b[2]) % Integer.parseInt(b[0]) != 0) {
                    floor = Integer.parseInt(b[2]) % Integer.parseInt(b[0]);
                    room = Integer.parseInt(b[2]) / Integer.parseInt(b[0]) + 1;
                }else {
                    floor = Integer.parseInt(b[0]);
                    room = Integer.parseInt(b[2]) / Integer.parseInt(b[0]);
                }
            }
            if(room < 10)
                System.out.println(Integer.toString(floor) + "0" + Integer.toString(room));
            else
                System.out.println(Integer.toString(floor) + Integer.toString(room));
        }
    }
}
