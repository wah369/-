package MAP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-17
 * Time: 21:14
 */
//////////////////////////////////////////////////////////////////////
class Solution {//坏键盘打字
    public static void search(String strA,String strB) {
        //把实际输出的字符放到集合中
        HashSet<Character> B = new HashSet<>();
        for (char ch : strB.toUpperCase().toCharArray()) {
            B.add(ch); //存放的就是实际输出的大写的字符
        }

        HashSet<Character> setBroken = new HashSet<>();

        char[] A = strA.toUpperCase().toCharArray();
        for (char ch2 : A) {
            if (!B.contains(ch2) && !setBroken.contains(ch2)) { //ch2是坏键盘
                setBroken.add(ch2);
                System.out.print(ch2);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String strA = scanner.nextLine();
            String strB = scanner.nextLine();
            search(strA,strB);
        }

    }
}
//////////////////////////////////////////////////////////////////////
class Solution3 {//宝石与石头
    //用set解决
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        HashSet<Character> setJ = new HashSet<>();
        char[] chJ = J.toCharArray();
        for (char ch : chJ) {
            setJ.add(ch);
        }
        char[] chS = S.toCharArray();
        for (char chs : chS) {
            if (setJ.contains(chs)) {
                count++;
            }
        }
        return count;
    }

    //基础方法循环嵌套
    public int numJewelsInStones1(String J, String S) {
        int num = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (J.charAt(i) == S.charAt(j)) {
                    num++;
                }
            }
        }
        return num;
    }
}

///////////////////////////////////////////////////////////////////////
//复制带随机指针的链表
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution2 {
    public Node copyRandomList(Node head) {
        Node cur = head;
        HashMap<Node,Node> map = new HashMap<>();
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur,node);
            cur = cur.next;
        }//cur == null 链表遍历完，新老节点对应关系建立完成
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
/////////////////////////////////////////////////////////////////////////
class Solution1 {
    //给定一个非空整数数组，除了某个元素只出现一次以外，
    // 其余每个元素均出现两次。找出那个只出现了一次的元素。
    //set解决
    public int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        for (int i : nums) {
            if (set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
    //异或解决
    public int singleNumber(int[] nums) {
        int ret = 0;
        //0异或任何数字都是它本身,两个相同的数字异或是0
        for (int i : nums) {
            ret ^= i;
        }
        return ret;
    }
}
