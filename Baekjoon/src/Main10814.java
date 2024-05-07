    import java.io.*;
    import java.util.ArrayList;
    import java.util.Objects;

    public class Main10814 {
        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(bf.readLine());

            String[] arr = new String[200];

            for(int i = 0 ; i < N ; i ++){
                String tmpSt = bf.readLine();
                String[] tmp = tmpSt.split(" ");
                int NA = Integer.parseInt(tmp[0])-1;
                if(arr[NA] == null)
                    arr[NA] = tmp[1];
                else
                    arr[NA] = arr[NA] + " " + tmp[1];
            }

            for(int i = 0 ; i < 200 ; i++){
                if(arr[i] != null){
                    String[] tmpArr = arr[i].split(" ");
                    int num = i + 1;
                    for(int j = 0 ; j < tmpArr.length ; j++) {
                        bw.write(num + " " + tmpArr[j] + "\n");
                    }
                }
            }
            bw.flush();
        }
    }
