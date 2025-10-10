class Solution {

    private int bestSubscribers = 0;
    private int bestSales = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] discount = new int[emoticons.length];
        dfs(users, emoticons, discount, 0);
        return new int[]{bestSubscribers, bestSales};
    }

    // 할인 조합으로 계산
    private Ans cal(int[][] users, int[] emoticons, int[] discounts) {
        int subscriber = 0;
        int sales = 0;

        for (int[] user : users) {
            int needDiscount = user[0];   // 사용자가 요구하는 최소 할인율
            int subscribeThreshold = user[1]; // 이 금액 이상이면 구독
            int total = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= needDiscount) {
                   
                    int discountedPrice = emoticons[i] * (100 - discounts[i]) / 100;
                    total += discountedPrice; // 누적해야 함
                }
            }

            if (total >= subscribeThreshold) {
                subscriber++;
            } else {
                sales += total;
            }
        }

        return new Ans(sales, subscriber);
    }

    // depth 자리의 할인율을 정하고 재귀
    private void dfs(int[][] users, int[] emoticons, int[] discount, int depth) {
        if (depth == discount.length) {
            Ans res = cal(users, emoticons, discount);

            if (res.subscriber > bestSubscribers ||
               (res.subscriber == bestSubscribers && res.sales > bestSales)) {
                bestSubscribers = res.subscriber;
                bestSales = res.sales;
            }
            return;
        }

        // 현재 depth 자리만 설정하고 재귀 호출
        for (int d = 10; d <= 40; d += 10) {
            discount[depth] = d;
            dfs(users, emoticons, discount, depth + 1);
        }
    }

    // 결과 담는 클래스 (Solution 내부에 두는 게 편리)
    private static class Ans {
        int sales;
        int subscriber;
        public Ans(int sales, int subscriber) {
            this.sales = sales;
            this.subscriber = subscriber;
        }
    }
}
