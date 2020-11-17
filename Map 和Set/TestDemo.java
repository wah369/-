package MAP;

import java.beans.beancontext.BeanContextChild;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-17
 * Time: 10:21
 */

public class TestDemo {

    /*Random random = new Random();
        for (int i = 0; i < array.length; i++) {
        //array[i] = i;
        array[i] = random.nextInt(10_0000);*/
    //list当中存放10万个数据，找到第一个重复的数据
    public static void main3(String[] args) {
       List<Integer> list = new ArrayList<>();
       Random random = new Random(100000);
        for (int i = 0; i < 100000; i++) {
            int num = random.nextInt(100000);
            list.add(num);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            if (set.contains(list.get(i))) {
                System.out.println(list.get(i));
            }else {
                set.add(list.get(i));
            }
        }
    }
    //把重复的数据去重
    public static void main4(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random(100000);
        for (int i = 0; i < 100000; i++) {
            int num = random.nextInt(100000);
            list.add(num);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i));
        }
    }
    //统计重复的数字以及出现的次数
    public static void main5(String[] args) {
        Random random = new Random(100000);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            int num = random.nextInt(100000);
            list.add(num);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer key : list) {
            if (map.get(key) == null) {
                map.put(key,1);
            }else {
                int val = map.get(key);
                map.put(key,val+1);
            }
        }
        for (Map.Entry<Integer,Integer> entry :map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("数字"+entry.getKey()+
                        "次数"+entry.getValue());
            }
        }

    }


    public static void main2(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("ab");
        set.add("bc");
        set.add("ab");
        System.out.println(set);
        //迭代器
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(set.size());
        it.remove();
        System.out.println(set.size());
    }
    public static void main1(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("及时雨","宋江");
        System.out.println(map.get("及时雨"));
        //打印所有对应关系：
        for(Map.Entry<String,String> entry: map.entrySet()) {
            System.out.println(entry);
        }
    }
}
