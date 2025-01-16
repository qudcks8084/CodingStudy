import java.util.Scanner;

public class Main2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int answer = 0;
        int n = Integer.parseInt(s);
        int k = s.length() * 9;

        for(int i = Math.max(n-k, 1) ; i < n ; i++){
            String[] tmp = String.valueOf(i).split("");
            int num = i;
            for (String string : tmp) {
                num += Integer.parseInt(string);
            }
            if(num == n) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
