import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[][] items = {
                {66000, 0, 50},
                {16000, 2, 10},
                {84500, 3, 20},
                {5500, 2, 75},
        };
        int N = 4;

        Solution(N, items);
    }

    public static void Solution(int N, int[][] items) {
        // 우선순위 큐를 할인 금액이 큰 순서대로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int discountA = a[0] * a[2] / 100;
            int discountB = b[0] * b[2] / 100;
            return Integer.compare(discountB, discountA);
        });

        // 큐에 모든 상품을 추가
        for (int i = 0; i < items.length; i++) {
            int[] item = {items[i][0], items[i][1], items[i][2], i};
            pq.offer(item);
        }

        // 구매 내역을 기록하기 위한 HashSet과 리스트
        Set<Integer> purchaseDays = new HashSet<>();
        List<int[]> purchases = new ArrayList<>();
        int totalCost = 0;
        int remainingItems = items.length;

        // 우선순위 큐에서 할인 금액이 큰 상품부터 처리
        while (!pq.isEmpty()) {
            int[] item = pq.poll();
            int price = item[0];
            int discountDay = item[1];
            int discountRate = item[2];
            int discountedPrice = price * (100 - discountRate) / 100;
            int index = item[3];

            // 남은 상품이 남은 날짜보다 많다면 중복된 날짜에 구매
            if (!purchaseDays.contains(discountDay) || remainingItems > N - purchaseDays.size()) {
                totalCost += discountedPrice;
                purchases.add(new int[]{discountDay, index, 1});  // 할인 받았음
                purchaseDays.add(discountDay);
                remainingItems--;
            }

            // 모든 상품을 다 구매하면 종료
            if (remainingItems == 0) {
                break;
            }
        }

        // 남은 상품들 처리
        for (int i = 0; i < items.length; i++) {
            boolean alreadyBought = false;
            for (int[] purchase : purchases) {
                if (purchase[1] == i) {
                    alreadyBought = true;
                    break;
                }
            }
            if (!alreadyBought) {
                for (int day = 1; day <= N; day++) {
                    if (!purchaseDays.contains(day)) {
                        totalCost += items[i][0];
                        purchases.add(new int[]{day, i, 0});  // 할인 받지 않음
                        purchaseDays.add(day);
                        remainingItems--;
                        break;
                    }
                }
            }
        }

        // 결과 출력
        System.out.println("최소 금액: " + totalCost);
        System.out.println("구매 내역 (날짜, 상품 번호, 할인 여부):");
        for (int[] purchase : purchases) {
            System.out.println("날짜: " + purchase[0] + ", 상품 번호: " + purchase[1] + ", 할인 여부: " + (purchase[2] == 1 ? "할인 받음" : "할인 안 받음"));
        }
    }
}
