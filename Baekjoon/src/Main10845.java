import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] Ins = bf.readLine().split(" ");
            if (Ins.length == 2) {
                if (Objects.equals(Ins[0], "push")) {
                    arr.add(Integer.parseInt(Ins[1]));
                }
            } else {
                if (Objects.equals(Ins[0], "pop")) {
                    if (arr.isEmpty()) {
                        bw.write("-1" + "\n");
                    } else {
                        bw.write(String.valueOf(arr.get(0)) + "\n");
                        arr.remove(0);
                    }
                } else if (Objects.equals(Ins[0], "size")) {
                    bw.write(arr.size() + "\n");
                } else if (Objects.equals(Ins[0], "empty")) {
                    if (arr.isEmpty()) {
                        bw.write("1" + "\n");
                    } else {
                        bw.write("0" + "\n");
                    }
                } else if (Objects.equals(Ins[0], "front")) {
                    if (arr.isEmpty()) {
                        bw.write("-1" + "\n");
                    } else {
                        bw.write(String.valueOf(arr.get(0)) + "\n");
                    }
                } else if (Objects.equals(Ins[0], "back")) {
                    if (arr.isEmpty()) {
                        bw.write("-1" + "\n");
                    } else {
                        bw.write(String.valueOf(arr.get(arr.size() - 1)) + "\n");
                    }
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
