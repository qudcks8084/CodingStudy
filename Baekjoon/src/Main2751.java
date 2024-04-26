import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
public class Main2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfNumbers = Integer.parseInt(bf.readLine());
        ArrayList<Integer> arrayInt = new ArrayList<>();

        for (int i = 0; i < numOfNumbers; i++) {
            arrayInt.add(Integer.parseInt(bf.readLine()));
        }

        Collections.sort(arrayInt);

        for (int i = 0; i < numOfNumbers; i++) {
            bw.write(arrayInt.get(i) + "\n");
        }
        bw.flush();
    }
}