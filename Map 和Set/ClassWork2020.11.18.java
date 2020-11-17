package MAP;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-17
 * Time: 22:47
 */
public class ClassWork {
}

class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            int count = map.getOrDefault(ch,0) + 1;
            map.put(ch,count);
        }
        //创建哈希表存储s中的元素和个数
        int index = 0;
        //遍历字符串
        while (index < s.length()){
            char tmp = s.charAt(index);
            //如果这个元素在哈希表中只有一个，返回这个元素下标
            if (map.get(tmp) == 1) {
                return index;
            }else {
                index++;
            }
        }
        return -1;
    }
}
class Solution7 {
//https://leetcode-cn.com/problems/intersection-of-two-arrays/solution/duo-chong-jie-fa-jie-jue-349-liang-ge-shu-zu-de-ji/
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        int i = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums1) {
            int count = map.getOrDefault(num,0) + 1;
            map.put(num,count);
        }
        for (int num : nums2) {
            if (map.containsKey(num)) {
                arr[i++] = num;
                map.remove(num);
                //根据上一题写，不用次数减，直接删除
            }
        }
        return Arrays.copyOfRange(arr,0,i);
    }
}
class Solution6 {
    //给定两个字符串 s 和 t，判断它们是否是同构的
    //构建哈希表，让s为val，t为k，判断对应关系
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelp(s, t) && isIsomorphicHelp(t, s);

    }
    public boolean isIsomorphicHelp(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if (map.containsKey(ss)) {
                if (map.get(ss) != tt) {
                    return false;
                }
            }else {
                map.put(ss,tt);
            }
        }
        return true;
    }
}
class Solution5 {
    public int[] intersect(int[] nums1, int[] nums2) {
        //先判断两个数组大小，用大的创建哈希表，
        if (nums1.length < nums2.length) {
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num,0) + 1;
            map.put(num,count);
        }//此时创建好了哈希表所对应的元素和其个数
        int[] result = new int[nums2.length]; //取交集肯定取小的数组长度
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num,0);
            if (count > 0) {
                result[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num,count);
                }else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(result,0,index);
    }
}