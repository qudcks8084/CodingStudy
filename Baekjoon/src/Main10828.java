import java.io.*;

public class Main10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfInstruction = Integer.parseInt(bf.readLine());
        int[] array = new int[numOfInstruction];
        int point = 0;

        for(int i = 0 ; i < numOfInstruction ; i++){
            String[] instruction = bf.readLine().split(" ");
            switch(instruction[0]){
                case "push" :
                    array[point] = Integer.parseInt(instruction[1]);
                    point++;
                    break;
                case "pop" :
                    if(point!=0){
                        point--;
                        bw.write(array[point] + "\n");
                    }else{
                        bw.write("-1\n");
                    }
                    break;
                case "size" :
                    bw.write(point+"\n");
                    break;
                case "empty":
                    if((point == 0))
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                    break;
                case "top" :
                    if(point == 0){
                        bw.write("-1\n");
                    } else
                        bw.write(array[point-1]+"\n");
                    break;
            }
        }
        bw.flush();
    }
}
