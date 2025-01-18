import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main2161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue<Integer> Q = new ArrayDeque<>();

        for(int i = 0 ; i < n ; i++){
            Q.offer(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        int index = 1;
        while (Q.size() > 1) {
            if(index % 2 == 1){
                sb.append(Q.poll()).append(" ");
            }else{
                Q.offer(Q.poll());
            }
            index++;
        }
        sb.append(Q.poll());

        System.out.println(sb);
    }
}
