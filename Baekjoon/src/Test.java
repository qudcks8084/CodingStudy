public class Test {
    static int H = 1000, W = 1000, K = 10;

    public static void main(String[] args) {
        boolean[][][][] arr4D = new boolean[H][W][K][2];
        boolean[][][] arr3D1 = new boolean[H][W][K];
        boolean[][][] arr3D2 = new boolean[H][W][K];

        long start, end;

        // 4차원 배열 접근 테스트
        start = System.nanoTime();
        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                for (int k = 0; k < K; k++) {
                    arr4D[h][w][k][0] = true;
                    arr4D[h][w][k][1] = false;
                }
            }
        }
        end = System.nanoTime();
        System.out.println("4D array time: " + (end - start) + " ns");

        // 3차원 배열 2개 접근 테스트
        start = System.nanoTime();
        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                for (int k = 0; k < K; k++) {
                    arr3D1[h][w][k] = true;
                    arr3D2[h][w][k] = false;
                }
            }
        }
        end = System.nanoTime();
        System.out.println("3D arrays time: " + (end - start) + " ns");
    }
}