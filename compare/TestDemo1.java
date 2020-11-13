package compare;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-10
 * Time: 10:57
 */

/**
 * 1、自定义类型 怎么比较大小关系？
 * 2、
 */
class Card implements Comparable<Card>{
    public int rank; // 数值
    public String suit; // 花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * 以后  如果是自定义类型进行equals比较的时候
     * 一定要哦记得重写Object的equals方法
     * 如果不写：
     * if (this == obj) {
     *     return true;
     * }
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        //引用同一个对象
        if (this == obj) {
            return true;
        }
        //obj instanceof Card  obj是不是Card的实例
        //obj可以是card的子类  也可以是 Card 本身
        if (obj == null || !(obj instanceof Card)) {
            return false;
        }
        Card card = (Card) obj;
        if(this.rank == card.rank
                && this.suit.equals(card.suit)) {
            return true;
        }
        return false;
    }

    /**
     * 返回值等于0  想等
     * 大于0
     * 小于0
     * @param o
     * @return
     */
    @Override
    public int compareTo(Card o) {
        return this.rank - o.rank;
    }
}
public class TestDemo1 {
    public static void main(String[] args) {
        Card card1 = new Card(2,"♥");
        Card card2 = new Card(6,"♥");
        System.out.println(card1.compareTo(card2));

        //System.out.println(card1 < card2);
        //System.out.println(card1 == card2);
        //System.out.println(card1.equals(card2));

        /*String str1 = "hello";
        String str2 = new String("hello");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        */
       /* int a = 10;
        int b = 20;
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a == b);*/
    }
}
