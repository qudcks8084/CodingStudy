import java.util.Scanner;

public class Main1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arrayOfNumber = new int[26];
        String target = sc.nextLine();
        int temp;
        for (int i = 0; i < target.length(); i++) {
            temp = target.charAt(i);
            if (temp >= 65 && temp <= 90) { // 대문자
                arrayOfNumber[(temp - 65)]++;
            } else if (temp >= 97 && temp <= 122) {
                arrayOfNumber[(temp - 97)]++;
            }
        }
        int max = 0;
        char maxIndex = 0;
        for (int i = 0; i < 26; i++) {
            if (arrayOfNumber[i] > max) {
                max = arrayOfNumber[i];
                temp = i + 65; // 대문자로 변환
                maxIndex = (char) temp;
            } else if (arrayOfNumber[i] == max) {
                maxIndex = '?';
            }
        }
        System.out.println(maxIndex);
    }
}
