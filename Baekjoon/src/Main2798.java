import java.util.Scanner;

public class Main2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] setting = sc.nextLine().split(" ");
        String[] array_String = sc.nextLine().split(" ");

        int numOfCard = Integer.parseInt(setting[0]);
        int sumOfCard = Integer.parseInt(setting[1]);

        int[] array_Int = new int[numOfCard];

        for(int i = 0 ; i < numOfCard ; i++){
            array_Int[i] = Integer.parseInt(array_String[i]);
        }

        int answer = search(array_Int, numOfCard, sumOfCard);

        System.out.println(answer);

    }

    static int search(int[] nums, int N, int M) {
        int result = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {

                    int answer = nums[i] + nums[j] + nums[k];

                    if (M == answer) {
                        return answer;
                    }

                    if (result < answer && answer < M) {
                        result = answer;
                    }
                }
            }
        }

        return result;
    }
}
