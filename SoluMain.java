import java.util.PriorityQueue;
import java.util.Collections;

class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if (first != second) {
                maxHeap.offer(first - second);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}

public class SoluMain {

    public static void main(String[] args) {

        int[] stones = {2, 7, 4, 1, 8, 1};

        Solution obj = new Solution();

        int result = obj.lastStoneWeight(stones);

        System.out.println(result);
    }
}