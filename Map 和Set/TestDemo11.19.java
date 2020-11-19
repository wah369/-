/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-19
 * Time: 9:05
 */
//哈希表的增删查改都可以达到o1
class HashBuck {
    static class Node {
        public int data; //key  map.put(key,val);
        public int value;
        public Node next;

        public Node(int data,int value) {
            this.data = data;
            this.value = value;
        }
    }
    public Node[] array;
    public int usedSize;
    public HashBuck() {
        this.array = new Node[0];
        this.usedSize = 0;
    }

    public void put(int key,int value) {
        int index = key % this.array.length;
        for (Node cur = array[index]; cur != null; cur = cur.next) {
            if (key == cur.data) {
                int oldValue = cur.value;
                cur.value = value;
                return;
            }
        }
        Node node = new Node(key, value);
        node.next = array[index];
        array[index] = node;
        usedSize++;
        if (loadFactor() > 0.75) {
            resize();
        }
    }
    public double loadFactor() {
        return usedSize * 1.0 / array.length;
    }
    public void resize() {
        Node[] newArray = new Node[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            Node next;
            for (Node cur = array[i]; cur != null; cur = next) {
                next = cur.next;
                int index = cur.data % newArray.length;
                cur.next = newArray[index];
                newArray[index] = cur;
            }
        }
        array = newArray;
    }



    public int getValue(int key) {
        int index = key % array.length;
        Node head = array[index];
        for (Node cur = head; cur != null; cur = cur.next) {
            if (key == cur.data) {
                return cur.value;
            }
        }
        return -1;
    }
}


public class TestDemo {
    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,1);hashBuck.put(21,2);hashBuck.put(31,3);
        hashBuck.put(4,4);hashBuck.put(5,5);hashBuck.put(6,6);
        hashBuck.put(7,7);hashBuck.put(8,8);
        System.out.println("===============");


    }
}
