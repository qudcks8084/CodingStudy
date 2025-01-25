import java.util.Scanner;

public class Main15652 {
    static int n, m;
    static int[] arr, nums;
    static StringBuilder sb;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        nums = new int[m];

        for(int i = 0 ; i < n ; i++){
            arr[i] = i + 1;
        }

        sb = new StringBuilder();
        DFS(0, 0);
        System.out.println(sb);
    }

    public static void DFS(int depth, int start){
        if(depth == m){
            for (int num : nums) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }else{
            for(int i = start ; i < n ; i++){
                nums[depth] = arr[i];
                DFS(depth+1, i);
                nums[depth] = 0;
            }
        }

    }
}
