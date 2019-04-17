package hackersrank;

import java.util.Arrays;

public class JimAndOrder {
    public static void main(String[] args) {
        int[][] orders = {{8, 1},
                {4, 2},
                {5, 6},
                {3, 1},
                {4, 3}
        };
        class Pair implements Comparable<Pair> {
            int deliveryTime;
            int index;

            public Pair(int deliveryTime, int index) {
                this.deliveryTime = deliveryTime;
                this.index = index;
            }

            @Override
            public int compareTo(Pair o) {
                if (this.deliveryTime != o.deliveryTime)
                    return this.deliveryTime - o.deliveryTime;
                else
                    return this.index - o.index;
            }

            public int getIndex() {
                return index;
            }
        }
        int totalCustomers = orders.length;
        Pair[] data = new Pair[totalCustomers];

        for (int i = 0; i < totalCustomers; i++) {
            data[i] = new Pair(orders[i][0] + orders[i][1], i + 1);
        }
        Arrays.sort(data);
        int[] sol = Arrays.stream(data).mapToInt(a -> a.getIndex()).toArray();
    }


}
