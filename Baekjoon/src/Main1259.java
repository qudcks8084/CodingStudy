import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class Main1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str = br.readLine();
            if(str.equals("0"))
                break;
            else{
                String[] tmp = str.split("");
                LinkedList<Integer> arr = new LinkedList<>();
                LinkedList<Integer> arr2 = new LinkedList<>();
                for(String a : tmp){
                    int b = Integer.parseInt(a);
                    arr2.add(b);
                    arr.add(b);
                }
                Collections.reverse(arr);
                if(arr.equals(arr2)){
                    System.out.println("yes");
                }else
                    System.out.println("no");
            }

        }
    }
}
