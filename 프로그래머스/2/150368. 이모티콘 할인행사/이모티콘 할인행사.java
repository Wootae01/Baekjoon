class Solution {
    /** 이모티콘 할인율을 어떻게 하냐에 따라 가입자 수가 달라지는건가 각 이모티콘마다 할인율을 다르게 적용할 수도 있고 
        고객은 특정 할인율 이상인 모든 제품을 삼 각 이모티콘의 할인율을 정해서 가입자 최대로, 매출 최대로 설정하는 거네 
        음.. user가 최대 100명 이고 이모티콘도 7개 밖에 안되네? 
        일단 그냥 브루트포스는 맞는거 같은데 아 할인율이 4개 밖에 없네 중복 순열인가. 중복 순열로 모든 경우의 구하면서 계산해야되네
    */
    private int bestSubscribers = 0;
    private int bestSales = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] discount = new int[emoticons.length];
        dfs(users, emoticons, discount, 0);
        return new int[]{bestSubscribers, bestSales};
    }

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

        
        for (int d = 10; d <= 40; d += 10) {
            discount[depth] = d;
            dfs(users, emoticons, discount, depth + 1);
        }
    }

    private static class Ans {
        int sales;
        int subscriber;
        public Ans(int sales, int subscriber) {
            this.sales = sales;
            this.subscriber = subscriber;
        }
    }
}
