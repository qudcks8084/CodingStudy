import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

public class Main1918 {

    static int N;
    static char[] input;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Character> target = new ArrayDeque<>();
        ArrayDeque<Character> operator = new ArrayDeque<>();
        HashSet<Character> operators = new HashSet<>(Arrays.asList('+', '-', '*', '/'));


        input = br.readLine().toCharArray();
        for(int i = 0 ; i < input.length ; i++){
            char tmp = input[i];
            if(operators.contains(tmp)){
                operator.push(tmp);
            }else{
                target.push(tmp);
            }
        }
    }
}
