package compare;

import java.util.Arrays;
import java.util.Comparator;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-10
 * Time: 10:57
 */
class Person {
    public String name;
    public int age;
    public int score;

    public Person(String name,  int score,int age) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
public class TestDemo3 {

    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("c",12,98);
        people[1] = new Person("a",32,88);
        people[2] = new Person("d",82,78);

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
        AgeComparator ageComparator = new AgeComparator();
        ScoreCompartor scoreCompartor = new ScoreCompartor();
        Arrays.sort(people,new ScoreCompartor());

        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.score-o2.score;
            }
        });


        System.out.println("==================");

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
    }

}
