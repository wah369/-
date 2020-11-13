package compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-10
 * Time: 10:57
 */
public class TOPK {
    public static void topK(int[] array, int k) {
        //取前5个最小的元素
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < array.length; i++) {
            if(maxHeap.size() < k) {
                maxHeap.offer(array[i]);
            }else {
                int tmp = maxHeap.peek();
                if(array[i] <  tmp) {
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }
        System.out.println(maxHeap);
    }
    public static void main(String[] args) {
        int[] array = {12,45,2,7,10,8,19,56,32};
        //topK(array,5);
        Arrays.sort(array);
        for (int i = 0; i < 5; i++) {
            System.out.println(array[i]);
        }
    }
}
