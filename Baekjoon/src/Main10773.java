import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < k ; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0)
                stack.pop();
            else
                stack.push(tmp);
        }

        int answer = 0;
        for (int i : stack) {
            answer += i;
        }
        System.out.println(answer);
    }
}
