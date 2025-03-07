import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main1213 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] frequency = new int[26];
        char[] input = br.readLine().toCharArray();

        for(int i = 0 ; i < input.length ; i++){
            frequency[input[i] - 'A']++;
        }

        ArrayDeque<Character> even_stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int numOfOdd = 0;
        char odd = 'A';
        for(int i = 0 ; i < frequency.length ; i++){
            int numOfAlphabet = frequency[i];
            if(numOfAlphabet == 0) continue;

            if(numOfAlphabet % 2 == 0){ // 짝수라면
                for(int j = 0 ; j < numOfAlphabet / 2 ; j++){
                    sb.append((char)('A' + i));
                    even_stack.push((char)('A' + i));
                }
            }else { // 홀수 라면
                if(numOfOdd == 1){
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                for(int j = 0 ; j < numOfAlphabet / 2 ; j++){
                    sb.append((char)('A' + i));
                    even_stack.push((char)('A' + i));
                }
                odd = (char) ('A' + i);
                numOfOdd++;
            }
        }

        if(numOfOdd == 1) sb.append(odd); // 홀수를 가운데에다가 넣음
        while(!even_stack.isEmpty()) sb.append(even_stack.pop());

        System.out.println(sb);
    }
}
