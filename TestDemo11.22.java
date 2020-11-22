package com.MyHashSet;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-22
 * Time: 13:08
 */
class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}


class Bucket {
    private List<Pair<Integer, Integer>> bucket;

    public Bucket() {
        this.bucket = new LinkedList<Pair<Integer, Integer>>();
    }

    public Integer get(Integer key) {
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key))
                return pair.second;
        }
        return -1;
    }

    public void update(Integer key, Integer value) {
        boolean found = false;
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)) {
                pair.second = value;
                found = true;
            }
        }
        if (!found)
            this.bucket.add(new Pair<Integer, Integer>(key, value));
    }

    public void remove(Integer key) {
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)) {
                this.bucket.remove(pair);
                break;
            }
        }
    }
}

class MyHashMap {
    private int key_space;
    private List<Bucket> hash_table;


    public MyHashMap() {
        this.key_space = 2069;
        this.hash_table = new ArrayList<Bucket>();
        for (int i = 0; i < this.key_space; ++i) {
            this.hash_table.add(new Bucket());
        }
    }


    public void put(int key, int value) {
        int hash_key = key % this.key_space;
        this.hash_table.get(hash_key).update(key, value);
    }


    public int get(int key) {
        int hash_key = key % this.key_space;
        return this.hash_table.get(hash_key).get(key);
    }


    public void remove(int key) {
        int hash_key = key % this.key_space;
        this.hash_table.get(hash_key).remove(key);
    }
}


/*
class MyHashSet {
    private Bucket[] bucketArray;
    private int keyRange;

    *//** Initialize your data structure here. *//*
    public MyHashSet() {
        this.keyRange = 769;
        this.bucketArray = new Bucket[this.keyRange];
        for (int i = 0; i < this.keyRange; ++i)
            this.bucketArray[i] = new Bucket();
    }

    protected int _hash(int key) {
        return (key % this.keyRange);
    }

    public void add(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].insert(key);
    }

    public void remove(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].delete(key);
    }

    public boolean contains(int key) {
        int bucketIndex = this._hash(key);
        return this.bucketArray[bucketIndex].exists(key);
    }
}
class Bucket {
    private LinkedList<Integer> container;

    public Bucket() {
        container = new LinkedList<Integer>();
    }

    public void insert(Integer key) {
        int index = this.container.indexOf(key);
        if (index == -1) {
            this.container.addFirst(key);
        }
    }

    public void delete(Integer key) {
        this.container.remove(key);
    }

    public boolean exists(Integer key) {
        int index = this.container.indexOf(key);
        return (index != -1);
    }
}*/

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }

}

class Solution15 {
    //判断是否存在重复元素
    public boolean containsDuplicate(int[] nums) {
        //set中肯定没有重复元素
        Set<Integer> set = new HashSet();
        for(Integer s: nums) {
            if(!set.contains(s)) {
                set.add(s);
            }else {
                return true;
            }
        }
        return false;
    }
}

class Solution14 {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        Set<String> set = new HashSet();
        for(String s : banned) {
            set.add(s);
        }
        Map<String,Integer> map = new HashMap();
        String result = "";
        int index = 0;
        StringBuilder str = new StringBuilder();
        for(char c: paragraph.toCharArray()) {
            if(Character.isLetter(c)) {
                str.append(Character.toLowerCase(c));
            }else if (str.length() > 0) {
                String finalword = str.toString();
                if(!set.contains(finalword)) {
                    map.put(finalword,map.getOrDefault(finalword,0) + 1);
                    if(map.get(finalword) > index) {
                        index = map.get(finalword);
                        result = finalword;
                    }
                }
                str = new StringBuilder();
            }
        }
        return result;

    }

    public String mostCommonWord1(String paragraph, String[] banned) {
        paragraph += ".";  //让最后一个单词也能被识别
        //把禁用单词放入set中
        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        //创建一个哈希表
        Map<String, Integer> count = new HashMap();
        String ans = "";
        int ansfreq = 0;
        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }
}



