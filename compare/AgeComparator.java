package compare;

import java.util.Comparator;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-10
 * Time: 10:57
 */

public class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.age-o2.age;
    }
}
