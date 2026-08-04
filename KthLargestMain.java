import java.util.PriorityQueue;

class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}

public class KthLargestMain{

    public static void main(String[] args) {

        int k = 3;
        int[] nums = {4, 5, 8, 2};

        KthLargest kthLargest = new KthLargest(k, nums);

        System.out.println(kthLargest.add(3));   // 4
        System.out.println(kthLargest.add(5));   // 5
        System.out.println(kthLargest.add(10));  // 5
        System.out.println(kthLargest.add(9));   // 8
        System.out.println(kthLargest.add(4));   // 8
    }
}