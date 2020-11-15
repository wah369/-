
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-15
 * Time: 20:14
 */

class Solution {
    //leetcode373. 查找和最小的K对数字
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 大顶堆
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, (o1, o2)->{
            return (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1));
        });

        // 遍历所有可能的集合
        for(int i = 0; i < Math.min(nums1.length, k); i++){
            for(int j = 0; j < Math.min(nums2.length, k); j++){
                // 如果当前的两个数之和超过了堆顶元素,不用继续遍历
                if(queue.size() == k && nums1[i]+nums2[j]
                        > queue.peek().get(0) + queue.peek().get(1)){
                    break;
                }

                // 若比堆顶小，则弹出堆顶元素，把当前数对加入
                if(queue.size() == k){
                    queue.poll();
                }
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                queue.add(list);
            }
        }
        // 最后将元素弹出，倒序插入数组即可
        List<List<Integer>> res = new LinkedList<>();
        for(int i =0; i < k && !queue.isEmpty(); i++){
            res.add(0, queue.poll());
        }
        return res;
    }

    //1046. 最后一块石头的重量
    //优先级队列保证poll出来的元素一定是最大的，而且插入元素不用再排序
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int i = 0; i < stones.length; i++) {
            priorityQueue.offer(stones[i]);
        }
        while (priorityQueue.size() > 1) {
            int x = priorityQueue.poll();
            int y = priorityQueue.poll();
            int tmp = x - y;
            if (tmp != 0) {
                priorityQueue.offer(tmp);
            }
        }
        if (priorityQueue.size() == 0) return 0;
        return priorityQueue.peek();
    }







}



